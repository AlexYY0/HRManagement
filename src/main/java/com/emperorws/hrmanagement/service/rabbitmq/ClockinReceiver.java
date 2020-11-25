package com.emperorws.hrmanagement.service.rabbitmq;

import com.emperorws.hrmanagement.model.Attelogday;
import com.emperorws.hrmanagement.model.RabbitMQConstants;
import com.emperorws.hrmanagement.service.AttelogdayService;
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
 * @Date: 2020/4/5 11:14
 * @Description: 打卡消息队列的消费者
 **/
@Component
public class ClockinReceiver {
    public static final Logger logger= LoggerFactory.getLogger(ClockinReceiver.class);
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    AttelogdayService attelogdayService;

    @RabbitListener(queues = RabbitMQConstants.CLOCKIN_QUEUE_NAME)
    public void handler(Message message, Channel channel) throws IOException {
        Attelogday attelogday=(Attelogday)message.getPayload();
        MessageHeaders messageHeaders=message.getHeaders();
        Long tag = (Long) messageHeaders.get(AmqpHeaders.DELIVERY_TAG);
        String msgid = (String) messageHeaders.get("spring_returned_message_correlation");
        if(redisUtil.hfind("clockinlog",msgid)){
            //redis 中包含该 key，说明该消息已经被消费过
            logger.info(msgid + ":消息已经被消费。");
            channel.basicAck(tag, false);//确认消息已消费
            return;
        }
        //收到消息，处理数据
        if(attelogdayService.updateAttelogday(attelogday)==1){
            redisUtil.hset("clockinlog",msgid,"success");
            channel.basicAck(tag, false);
            logger.info(msgid + ":数据处理成功，打卡成功");
        }else {
            channel.basicNack(tag, false, true);
            logger.error("数据处理失败，打卡失败。");
        }
    }
}
