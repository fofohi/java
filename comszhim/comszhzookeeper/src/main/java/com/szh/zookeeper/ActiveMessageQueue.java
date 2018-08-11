package com.szh.zookeeper;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * Created by alongsea2 on 2017/3/27.
 */
public class ActiveMessageQueue {
    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp:///10.10.11.208:61616");
        try {
            String x = "/Users/alongsea2/Downloads/1.txt";
            BufferedReader fileInputStream = new BufferedReader(new FileReader(new File(x)));
            ActUserRegisterDTO a;
            String xx = null;
            do {
                xx = fileInputStream.readLine();
                if(xx != null){
                    String[] ss = xx.split(",");
                    a = new ActUserRegisterDTO();
                    a.setUserId(Long.parseLong(ss[0]));
                    a.setEntranceId(ss[2]);
                    a.setUuid(ss[1]);
                    ClientRequestHeader header = new ClientRequestHeader();
                    header.setUserID(Long.parseLong(ss[0]) + "");
                    header.setUuid(ss[1]);
                    header.setCmdName(ss[2]);
                    a.setHeader(header);
                }
            }while (xx != null);



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


        } catch (Exception e) {
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
