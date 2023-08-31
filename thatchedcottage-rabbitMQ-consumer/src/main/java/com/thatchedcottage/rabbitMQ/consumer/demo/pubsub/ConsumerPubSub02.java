package com.thatchedcottage.rabbitMQ.consumer.demo.pubsub;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: thatchedcottage
 * @description: RabbitMQ 消费者pubsub 工作模式 测试类
 * @author:
 * @create: 2023-08-30 09:11
 **/
public class ConsumerPubSub02 {

    /* 交换机名字 */
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {

        //1 创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置 rabbititmq ip 地址
        connectionFactory.setHost("localhost");
        //3 创建 Conection 对象
        Connection connection = connectionFactory.newConnection();
        //4 创建 Chanel
        Channel channel = connection.createChannel();

        /** 5指定交换机类型
         * 第一个参数：交换机名字
         * 第二个参数：交换机类型
         */
        /**
         * Exchange有常见以下3种类型：
         * Fanout ：广播，将消息交给所有绑定到交换机的队列
         * Direct ：定向，把消息交给符合指定routing key 的队列
         * Topic ：通配符，把消息交给符合routing pattern（路由模式） 的队列
         */
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        //6使用 chanel 去 rabbitmq 中去取消息进行消费
        /**
         * 第一个参数：队列名称
         * 第二个参数：是否自动签收
         */
        channel.basicConsume(queueName, true, new DeliverCallback() {
            /**
             * 当消息从 mq 中取出来了会回调这个方法
             * 消费者消费消息就在这个 handle中去进行处理
             */
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("ConsumerTest02消息内容为为" + new String(message.getBody()));
            }

        }, new CancelCallback() {
            /**
             * 当消息取消了会回调这个方法
             * @param consumerTag
             * @throws IOException
             */
            public void handle(String consumerTag) throws IOException {
                System.out.println("1111");
            }
        });

    }
}
