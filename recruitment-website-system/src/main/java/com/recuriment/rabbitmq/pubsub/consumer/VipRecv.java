package com.recuriment.rabbitmq.pubsub.consumer;

import com.recuriment.rabbitmq.pubsub.config.PubsubQueueConfig;
import com.recuriment.rabbitmq.workqueue.config.MqWorkQueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 * TODO
 *
 * @author 李秋平
 * @module TODO
 * @date 2021/10/27 14:50
 * @copyright 2021 Big Cute Lee. All rights reserved
 */
//@Component
public class VipRecv {

    @RabbitListener(queues = PubsubQueueConfig.QUEUE_VIP)
    public void receive1(String message) {
        System.out.println("[VipRecv]消费者收到消息：" + message);
    }

}
