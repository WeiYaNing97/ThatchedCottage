package com.thatchedcottage.rabbitMQ.consumer.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: thatchedcottage
 * @description: RabbitMQ 消费者work工作模式 测试类
 * @author:
 * @create: 2023-08-30 09:11
 **/
public class ConsumerTest02 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置 rabbititmq ip 地址
        connectionFactory.setHost("localhost");
        //3 创建 Conection 对象
        Connection connection = connectionFactory.newConnection();
        //4 创建 Chanel
        Channel channel = connection.createChannel();
        //5 设置队列属性
        /**
         * 第一个参数：队列名称
         * 第二个参数：队列是否要持久化
         * 第三个参数：是否排他性
         * 第四个参数：是否自动删除,如果没有消费者连接就自动删除
         * 第五个参数：是否要设置一些额外参数
         */
        channel.queueDeclare("01-hello",true,false,false,null);

        /**
         * @Description 设置一次只能取一条。 能者多劳
         * 如果不设置的话，会出现：例如有2个消费者，会先平分 N个消费者传入的消息，再做处理，即两个消费者，平分消费者的100条信息
         *
         * 注意：需要手动签收
         */
        channel.basicQos(1);

        //6使用 chanel 去 rabbitmq 中去取消息进行消费
        /**
         * 第一个参数：队列名称
         * 第二个参数：是否自动签收
         */
        channel.basicConsume("01-hello", false, new DeliverCallback() {
            /**
             * 当消息从 mq 中取出来了会回调这个方法
             * 消费者消费消息就在这个 handle中去进行处理
             */
            public void handle(String consumerTag, Delivery message) throws IOException {
                System.out.println("ConsumerTest02消息内容为为" + new String(message.getBody()));
                channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
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
