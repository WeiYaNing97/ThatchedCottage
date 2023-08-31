package com.thatchedcottage.rabbitMQ.producer.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @program: thatchedcottage
 * @description: Springboot整合RabbitMQ的生产者测试类
 * @author:
 * @create: 2023-08-31 11:20
 **/
@RestController
@RequestMapping("/ProducerWorkController")
public class ProducerWorkController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/producerMsg")
    @ResponseBody
    public String producerTest(String msg) {

        for (int i=0;i<100;i++){
            rabbitTemplate.convertAndSend("","springboot_rabbitMQ_work",msg+" "+i);
        }

        return "发送成功";
    }

}
