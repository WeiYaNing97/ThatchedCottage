package com.thatchedcottage.rabbitMQ.consumer.test;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @program: thatchedcottage
 * @description: Springboot整合RabbitMQ的消费者测试类
 * @author:
 * @create: 2023-08-31 11:27
 **/
/**
* @Description
 * @ Component注解是Spring框架中的一个注解，用于标识一个类为一个可被Spring容器管理的组件。
 * 被@Component注解标识的类将会被Spring自动扫描并加载到应用上下文中，可以通过依赖注入等方式进行使用。
*/
@Component
public class ConsumerController {
    @RabbitListener(queuesToDeclare = @Queue("springboot_rabbitMQ"))
    public void receiveMsg(String msg, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel){
        System.out.println("========收到消息:"+msg);
    }
}
