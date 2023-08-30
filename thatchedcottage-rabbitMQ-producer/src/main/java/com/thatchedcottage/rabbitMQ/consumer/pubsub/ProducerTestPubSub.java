package com.thatchedcottage.rabbitMQ.consumer.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: thatchedcottage
 * @description: RabbitMQ  pubsub工作模式 测试类
 * @author:
 * @create: 2023-08-30 09:08
 **/
public class ProducerTestPubSub {

    /*交换机名字*/
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

        /** 5
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

        //6 发送消息
        /**
         * 第一个参数： 交换机名称
         * 第二个参数： 路由 key
         * 第三个参数： 消息属性
         * 第四个参数： 消息内容
         */
        for (int i=0;i<100;i++){
            channel.basicPublish(EXCHANGE_NAME, "", null, ("pub/sub 订阅模式测试"+i).getBytes("UTF-8"));
        }

        //7 关闭资源
        channel.close();
        connection.close();
    }
}
