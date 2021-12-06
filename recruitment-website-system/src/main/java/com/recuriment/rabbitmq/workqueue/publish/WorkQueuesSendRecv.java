package com.recuriment.rabbitmq.workqueue.publish;

import cn.hutool.core.util.RandomUtil;
import com.recuriment.rabbitmq.direct.config.DirectConfig;
import com.recuriment.rabbitmq.workqueue.config.MqWorkQueueConfig;
import org.springframework.amqp.core.AmqpTemplate;
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
public class WorkQueuesSendRecv {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("send2")
    public void send() {
        int i = 0;
        while (true) {
            amqpTemplate.convertAndSend(MqWorkQueueConfig.QUEUE_NAME, "消息" + i);
            i = i + 1;
            try {
                Thread.sleep(RandomUtil.randomInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
