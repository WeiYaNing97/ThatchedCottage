package com.thatchedcottage.rabbitMQ.consumer.topic;

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
public class ConsumerTopic01 {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "boot_topic_queue01"),
            exchange = @Exchange(name = "boot_topic_exchange",type = "topic"),
            key = {"error.*","info.*"}
    ))

    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG)long deliveryTag, Channel channel) throws Exception {
        System.out.println("error.*&info.* 收到消息:"+msg);
        channel.basicAck(deliveryTag,false);
    }
}
