package com.cloud.rabbitmq.simpleclient.demo1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * @author: Administrator
 * @date : 2017/5/2 0002
 * @Description:
 */
public class Producer {

    private final static String QUEUE_NAME = "hello";
    private final static String VHOST = "demoServer";
    private final static String USERNAME = "meddkim";
    private final static String PASSWORD = "meddkim";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.0.0.64");
        factory.setVirtualHost(VHOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "this is my demo";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
