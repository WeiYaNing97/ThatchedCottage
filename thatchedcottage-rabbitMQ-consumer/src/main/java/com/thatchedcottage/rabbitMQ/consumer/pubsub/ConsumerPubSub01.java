package com.thatchedcottage.rabbitMQ.consumer.pubsub;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: thatchedcottage
 * @description: pubsub模式
 * @author:
 * @create: 2023-08-31 14:33
 **/
@Component
public class ConsumerPubSub01 {
    /*@Queue 为匿名消息队列*/
    @RabbitListener(
            bindings = @QueueBinding(
                value = @Queue,//队列名
                exchange = @Exchange(name = "boot_pubsub",type = "fanout")))//交换机名 交换机类型
    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) throws Exception {
        System.out.println("收到消息1:"+msg);
        channel.basicAck(deliveryTag,false);
    }
}
