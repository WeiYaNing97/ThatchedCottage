package com.thatchedcottage.rabbitMQ.consumer.work;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: thatchedcottage
 * @description: work模式
 * @author:
 * @create: 2023-08-31 14:33
 **/
@Component
public class ConsumerWork01 {
    @RabbitListener(queuesToDeclare = @Queue("springboot_rabbitMQ_work"))
    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {

        System.out.println("消费者1收到消息:"+msg);

        /*手动签收*/
        /*如果为 false，则只确认当前的 deliveryTag 对应的消息；如果为 true，则确认当前 deliveryTag 及之前所有未确认的消息。*/
        channel.basicAck(deliveryTag,false);
    }
}
