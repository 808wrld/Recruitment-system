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
public class CommonRecv {

    @RabbitListener(queues = PubsubQueueConfig.QUEUE_COMMON)
    public void receive1(String message) {
        System.out.println("[CommonRecv]消费者收到消息：" + message);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @RabbitListener(queues = PubsubQueueConfig.QUEUE_COMMON)
    public void receive2(String message) {
        System.out.println("[CommonRecv2]消费者收到消息：" + message);
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
