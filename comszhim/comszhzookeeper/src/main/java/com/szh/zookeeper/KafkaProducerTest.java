package com.szh.zookeeper;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created by alongsea2 on 2017/3/22.
 */
public class KafkaProducerTest implements Runnable{

    private Producer producer;

    public static void main(String[] args) {
        new Thread(new KafkaProducerTest()).start();
    }

    public KafkaProducerTest() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("client.id", "test");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        producer = new KafkaProducer<String,String>(properties);
    }

    @Override
    public void run() {
        for(int i=0;i<2;i++){
            producer.send(new ProducerRecord<String,String>("test",System.currentTimeMillis() + "msg" + i));
        }
        producer.close();
    }
}
