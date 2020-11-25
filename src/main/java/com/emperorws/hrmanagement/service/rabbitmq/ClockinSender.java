package com.emperorws.hrmanagement.service.rabbitmq;

import com.emperorws.hrmanagement.model.Attelogday;
import com.emperorws.hrmanagement.model.RabbitMQConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/6 12:57
 * @Description: 消息队列发送者类
 **/
@Component
public class ClockinSender {
    public static final Logger logger= LoggerFactory.getLogger(ClockinSender.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 需要立即消费的消息投递方法
     * @param attelogday
     * @param msgid
     */
    public void sendMsg(Attelogday attelogday,String msgid){
        rabbitTemplate.convertAndSend(RabbitMQConstants.CLOCKIN_EXCHANGE_NAME, RabbitMQConstants.CLOCKIN_ROUTING_KEY_NAME,attelogday,new CorrelationData(msgid));
        logger.info("开始发送消息："+msgid);
    }

    /**
     * 需要延迟消费的消息投递方法
     * @param attelogday
     * @param msgid
     * @param retry
     */
    public void sendDelayMsg(Attelogday attelogday,String msgid,int retry){
        rabbitTemplate.convertAndSend(RabbitMQConstants.DELAY_EXCHANGE_NAME, RabbitMQConstants.DELAY_ROUTING_KEY_NAME, attelogday, (message) -> {
            message.getMessageProperties().setHeader("x-delay",60000);
            message.getMessageProperties().setHeader("retry",retry);
            return message;
        },new CorrelationData(msgid));
        logger.info("开始发送延迟消息："+msgid);
    }
}
