package com.thatchedcottage.rabbitMQ.producer.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: thatchedcottage
 * @description: producer rounting 生产者
 * @author:
 * @create: 2023-08-31 15:39
 **/
@Controller
@RequestMapping("/ProducerTopicController")
public class ProducerTopicController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/topic")
    @ResponseBody
    public String sendMsg(String key){
        rabbitTemplate.convertAndSend("boot_topic_exchange",key,"topic消息:"+key);
        return "发送成功";
    }
}
