package com.recuriment.rabbitmq.pubsub.produce;

import com.recuriment.rabbitmq.direct.config.DirectConfig;
import com.recuriment.rabbitmq.pubsub.config.PubsubQueueConfig;
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
public class PubsubSendRecv {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("sendVip")
    public void send() {
        amqpTemplate.convertAndSend(PubsubQueueConfig.EXCHANGE_NAME, PubsubQueueConfig.QUEUE_VIP, "这是一条vip公告");
    }

    @GetMapping("sendCommon")
    public void sendCommon(){
        amqpTemplate.convertAndSend(PubsubQueueConfig.EXCHANGE_NAME, PubsubQueueConfig.QUEUE_COMMON, "这是一条普通公告");
    }

}
