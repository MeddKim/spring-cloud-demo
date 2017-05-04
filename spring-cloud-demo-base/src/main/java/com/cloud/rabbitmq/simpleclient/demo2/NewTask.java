package com.cloud.rabbitmq.simpleclient.demo2;

import com.cloud.rabbitmq.simpleclient.Const;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: Administrator
 * @date : 2017/5/2 0002
 * @Description:
 */
public class NewTask {

    private static String TASK_QUEUE_NAME = "task_queue";


    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("10.0.0.64");
        factory.setVirtualHost(Const.VHOST);
        factory.setUsername(Const.USERNAME);
        factory.setPassword(Const.PASSWORD);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(TASK_QUEUE_NAME,true,false,false,null);

        String message = getMessage(args);
//        String message = "this is my demo";

        channel.basicPublish("",TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
