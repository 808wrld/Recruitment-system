package com.recuriment.rabbitmq.direct.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 模式一  简单模式
 *
 * 生产者 发布消息至 消息队列
 * 消费者 会持续监控消息队列等待消费
 *
 *
 * @author 李秋平
 * @module TODO
 * @date 2021/10/27 14:40
 * @copyright 2021 Big Cute Lee. All rights reserved
 */
//@Configuration
public class DirectConfig {

    public static final String MQ_NAME = "direct";

    @Bean
    public Queue createQueue() {
        // 创建一个命名消息队列
        return new Queue(MQ_NAME);
    }
}
