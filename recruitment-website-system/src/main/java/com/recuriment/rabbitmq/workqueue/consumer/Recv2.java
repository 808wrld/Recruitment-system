package com.recuriment.rabbitmq.workqueue.consumer;

import com.recuriment.rabbitmq.direct.config.DirectConfig;
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
public class Recv2 {

    @RabbitListener(queues = MqWorkQueueConfig.QUEUE_NAME)
    public void receive1(String message) {
        System.out.println("[Recv2]消费者收到消息：" + message);
    }

}
