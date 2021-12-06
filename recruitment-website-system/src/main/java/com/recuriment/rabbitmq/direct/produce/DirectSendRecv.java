package com.recuriment.rabbitmq.direct.produce;

import com.recuriment.rabbitmq.direct.config.DirectConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.RabbitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 * TODO
 *
 * @author 李秋平
 * @module TODO
 * @date 2021/10/27 14:45
 * @copyright 2021 Big Cute Lee. All rights reserved
 */
//@RestController
public class DirectSendRecv {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("send")
    public void send() {
        while (true) {
            int i = 0;
            amqpTemplate.convertAndSend(DirectConfig.MQ_NAME, "消息" + i++);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
