package com.emperorws.hrmanagement.controller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/4 23:58
 * @Description: 消息队列RabbitMQ配置类
 **/
@Configuration
public class RabbitConfig {
    public final static Logger logger= LoggerFactory.getLogger(RabbitConfig.class);
    @Autowired
    CachingConnectionFactory cachingConnectionFactory;
    /*@Autowired
    ClockinlogService clockinlogService;*/

    @Bean
    RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);
        rabbitTemplate.setConfirmCallback((data, ack, cause) -> {
            String msgid = data.getId();
            if (ack) {
                logger.info(msgid + ":消息发送到交换机成功");
                //clockinlogService.updateClockinlogStatus(msgid, 1);//修改数据库中的记录，消息投递成功
            } else {
                logger.info(msgid + ":消息发送到交换机失败："+cause);
            }
        });
        rabbitTemplate.setReturnCallback((msg, repCode, repText, exchange, routingkey) -> {
            logger.info("消息发送到队列失败："+repText);
        });
        return rabbitTemplate;
    }

    /*@Bean
    Queue clockinQueue() {
        return new Queue(RabbitMQConstants.CLOCKIN_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange clockinExchange() {
        return new DirectExchange(RabbitMQConstants.CLOCKIN_EXCHANGE_NAME, true, false);
    }

    @Bean
    Binding clockinBinding() {
        return BindingBuilder.bind(clockinQueue()).to(clockinExchange()).with(RabbitMQConstants.CLOCKIN_ROUTING_KEY_NAME);
    }*/
}
