package com.emperorws.hrmanagement.controller.config;

import com.emperorws.hrmanagement.model.RabbitMQConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/6 15:13
 * @Description: 正常消息的配置类
 **/
@Configuration
public class MsgConfig {
    @Bean
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
    }
}
