package com.recuriment.rabbitmq.direct.comsumer;

import com.recuriment.rabbitmq.direct.config.DirectConfig;
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
public class Recv {

    @RabbitListener(queues = DirectConfig.MQ_NAME)
    public void receive1(String message) {
        System.out.println("消费者收到消息：" + message);
    }

}
