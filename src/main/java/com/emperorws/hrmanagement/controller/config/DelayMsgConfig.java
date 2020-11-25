package com.emperorws.hrmanagement.controller.config;

import com.emperorws.hrmanagement.model.RabbitMQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/6 14:15
 * @Description: 延迟消息配置类
 **/
@Configuration
public class DelayMsgConfig {

    @Bean
    Queue delayQueue(){
        return new Queue(RabbitMQConstants.DELAY_QUEUE_NAME);
    }

    @Bean
    CustomExchange delayExchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(RabbitMQConstants.DELAY_EXCHANGE_NAME,"x-delayed-message",true,false, args);
    }

    @Bean
    Binding delayBinding(){
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(RabbitMQConstants.DELAY_ROUTING_KEY_NAME).noargs();
    }
}
