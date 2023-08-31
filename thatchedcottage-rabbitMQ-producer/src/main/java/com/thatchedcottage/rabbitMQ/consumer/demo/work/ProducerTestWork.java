package com.thatchedcottage.rabbitMQ.consumer.demo.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: thatchedcottage
 * @description: RabbitMQ  work工作模式 测试类
 * @author:
 * @create: 2023-08-30 09:08
 **/
public class ProducerTestWork {

    public static void main(String[] args) throws IOException, TimeoutException {
        //1 创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置 rabbititmq ip 地址
        connectionFactory.setHost("localhost");
        //3 创建 Conection 对象
        Connection connection = connectionFactory.newConnection();
        //4 创建 Chanel
        Channel channel = connection.createChannel();
        /**5 指定交换机类型
         * 第一个参数：队列名称
         * 第二个参数：队列是否要持久化
         * 第三个参数：是否排他性
         * 第四个参数：是否自动删除
         * 第五个参数：是否要设置一些额外参数
         */
        channel.queueDeclare("01-hello",true,false,false,null);
        //6 发送消息
        /**
         * 第一个参数： 交换机名称
         * 第二个参数： 路由 key
         * 第三个参数： 消息属性
         * 第四个参数： 消息内容
         */
        for (int i=0;i<10000;i++){
            channel.basicPublish("","01-hello", MessageProperties.PERSISTENT_TEXT_PLAIN,("hello rabbitmq"+i).getBytes());
        }



        //7 关闭资源
        channel.close();
        connection.close();

    }
}
