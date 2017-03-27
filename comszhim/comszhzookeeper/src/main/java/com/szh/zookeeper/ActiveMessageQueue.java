package com.szh.zookeeper;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by alongsea2 on 2017/3/27.
 */
public class ActiveMessageQueue {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        try {
            new Thread(() -> {
                new ActiveMqConsumer().consumer();
            }).start();
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(Boolean.FALSE,
                    Session.AUTO_ACKNOWLEDGE);
            Queue destination = session.createQueue("TestQueue");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage("ActiveMq " + "HelloWorld ");
            // 发送消息到目的地方
            System.out.println("发送消息：" + "ActiveMq " + "HelloWorld ");
            producer.send(message);
            session.commit();


        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    private static class ActiveMqConsumer{

        public void consumer(){
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_USER,
                    ActiveMQConnection.DEFAULT_PASSWORD,
                    "tcp://localhost:61616");
            try {
                Connection connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(Boolean.FALSE,
                        Session.AUTO_ACKNOWLEDGE);
                Queue destination = session.createQueue("TestQueue");
                MessageConsumer consumer = session.createConsumer(destination);

                while (true) {
                    //设置接收者接收消息的时间，为了便于测试，这里谁定为100s
                    TextMessage message = (TextMessage) consumer.receive(100000);
                    if (null != message) {
                        System.out.println("收到消息：" + message.getText());
                    } else {
                        break;
                    }
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
