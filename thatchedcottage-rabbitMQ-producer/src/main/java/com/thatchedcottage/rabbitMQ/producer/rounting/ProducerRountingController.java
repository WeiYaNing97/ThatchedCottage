package com.thatchedcottage.rabbitMQ.producer.rounting;

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
@RequestMapping("/ProducerRountingController")
public class ProducerRountingController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/rounting")
    @ResponseBody
    public String sendMsg(String key){
        rabbitTemplate.convertAndSend("boot_rounting_exchange",key,"rounting消息:"+key);
        return "发送成功";
    }
}
