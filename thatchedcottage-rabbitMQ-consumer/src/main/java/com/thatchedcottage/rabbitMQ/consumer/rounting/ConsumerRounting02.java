package com.thatchedcottage.rabbitMQ.consumer.rounting;

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
 * @description: work模式
 * @author:
 * @create: 2023-08-31 14:33
 **/
@Component
public class ConsumerRounting02 {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "boot_rounting_queue02"),
            exchange = @Exchange(name = "boot_rounting_exchange",type = "direct"),
            key = {"error"}
    ))

    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) throws Exception {
        System.out.println("error 收到消息:"+msg);
        channel.basicAck(deliveryTag,false);
    }
}
