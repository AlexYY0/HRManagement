package com.emperorws.hrmanagement.controller.config;

import com.emperorws.hrmanagement.model.Attelogday;
import com.emperorws.hrmanagement.model.RabbitMQConstants;
import com.emperorws.hrmanagement.service.AttelogdayService;
import com.emperorws.hrmanagement.service.rabbitmq.ClockinSender;
import com.emperorws.hrmanagement.utils.RedisUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/6 15:59
 * @Description: 消息补偿机制
 **/
@Component
public class MsgCheck {
    public static final Logger logger= LoggerFactory.getLogger(MsgCheck.class);

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ClockinSender clockinSender;
    @Autowired
    AttelogdayService attelogdayService;

    @RabbitListener(queues = RabbitMQConstants.DELAY_QUEUE_NAME)
    public void checkMsg(Message message, Channel channel) throws IOException {
        Attelogday attelogday=(Attelogday)message.getPayload();
        MessageHeaders messageHeaders=message.getHeaders();
        int retry = (int)messageHeaders.get("retry");
        Long tag = (Long) messageHeaders.get(AmqpHeaders.DELIVERY_TAG);
        String msgid = (String) messageHeaders.get("spring_returned_message_correlation");
        if(redisUtil.hfind("clockinlog",msgid)){
            //redis 中包含该 key，说明该消息已经被消费过，不需要消息重发
            logger.info(msgid + ":消息已经被消费，不需要补偿重发。");
            channel.basicAck(tag, false);//确认消息已消费
            return;
        }
        //消息需要重发
        if(retry>=3){
            logger.error("消息补偿机制，无法继续发送，消息入库中......");
            attelogdayService.updateAttelogday(attelogday);
            channel.basicNack(tag,false,false);
        }else {
            channel.basicNack(tag,false,false);
            clockinSender.sendMsg(attelogday,msgid);
            clockinSender.sendDelayMsg(attelogday,msgid,retry+1);
            logger.info("消息补偿机制，第{}次重新发送中......",retry+1);
        }
    }
}
