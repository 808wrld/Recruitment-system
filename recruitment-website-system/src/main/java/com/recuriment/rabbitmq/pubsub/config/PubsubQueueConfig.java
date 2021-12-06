package com.recuriment.rabbitmq.pubsub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 * TODO
 *
 * @author 李秋平
 * @module TODO
 * @date 2021/10/27 15:18
 * @copyright 2021 Big Cute Lee. All rights reserved
 */
//@Configuration
public class PubsubQueueConfig {

    public static final String EXCHANGE_NAME = "topicEchange";
    public static final String QUEUE_VIP = "topic.vip";
    public static final String QUEUE_COMMON = "topic.common";

    @Bean
    public Queue queueVip() {
        // 创建一个命名消息队列
        return new Queue(QUEUE_VIP);
    }

    @Bean
    public Queue queueCommon() {
        // 创建一个命名消息队列
        return new Queue(QUEUE_COMMON);
    }

    @Bean
    public TopicExchange exchange() {
        // Topic交换器
        return new TopicExchange(EXCHANGE_NAME);
    }

    // 将对列绑定到Topic交换器（绑定后，修改代码不会自动解绑，要到MQ控制界面去解绑）
    // （VIP可以接收所有消息，采用#的方式）
    @Bean
    // 此处是自动绑定，参数名要求和上面的方法名一致
    Binding bindingExchangeVIP(Queue queueVip, TopicExchange exchange) {
        // with的参数是routingKey，范围比queue的那么要广
        return BindingBuilder.bind(queueVip).to(exchange).with("topic.#");
    }

    // 将对列绑定到Topic交换器
    @Bean
    Binding bindingExchange2(Queue queueCommon, TopicExchange exchange) {
        // 普通人只能接收部分消息
        return BindingBuilder.bind(queueCommon).to(exchange).with(QUEUE_COMMON);
    }

}
