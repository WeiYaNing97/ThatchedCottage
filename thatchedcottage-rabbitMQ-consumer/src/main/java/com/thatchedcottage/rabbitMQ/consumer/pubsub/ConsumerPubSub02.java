package com.thatchedcottage.rabbitMQ.consumer.pubsub;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @program: thatchedcottage
 * @description: pubsub模式
 * @author:
 * @create: 2023-08-31 14:33
 **/
@Component
public class ConsumerPubSub02 {
    /*@Queue 为匿名消息队列*/
    @RabbitListener(bindings = @QueueBinding(value = @Queue,exchange = @Exchange(name = "boot_pubsub",type = "fanout")))
    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) throws Exception {
        System.out.println("收到消息2:"+msg);
        channel.basicAck(deliveryTag,false);
    }
}
