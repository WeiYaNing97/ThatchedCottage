package com.thatchedcottage.rabbitMQ.producer.pubsub;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: thatchedcottage
 * @description: pubsub 生产者
 * @author:
 * @create: 2023-08-31 15:22
 **/
@RestController
@RequestMapping("/ProducerPubSubController")
public class ProducerPubSubController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/pubsub")
    @ResponseBody
    public String sendMsg(){
        rabbitTemplate.convertAndSend("boot_pubsub","","广播消息");
        return "发送成功";
    }
}
