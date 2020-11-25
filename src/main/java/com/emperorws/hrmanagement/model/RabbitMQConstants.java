package com.emperorws.hrmanagement.model;

/**
 * @Author: EmperorWS
 * @Date: 2020/4/5 0:05
 * @Description: 定义消息中间件的某些变量
 **/
public class RabbitMQConstants {
    public static final Integer DELIVERING = 0;//消息投递中
    public static final Integer SUCCESS = 1;//消息投递成功
    public static final Integer FAILURE = 2;//消息投递失败
    public static final Integer MAX_TRY_COUNT = 3;//最大重试次数
    public static final Integer MSG_TIMEOUT = 1;//消息超时时间

    public static final String CLOCKIN_QUEUE_NAME = "emperorws.clockin.queue";
    public static final String CLOCKIN_EXCHANGE_NAME = "emperorws.clockin.exchange";
    public static final String CLOCKIN_ROUTING_KEY_NAME = "emperorws.clockin.routing.key";

    public static final String DELAY_QUEUE_NAME = "emperorws.delay.queue";
    public static final String DELAY_EXCHANGE_NAME = "emperorws.delay.exchange";
    public static final String DELAY_ROUTING_KEY_NAME = "emperorws.delay.routing.key";
}
