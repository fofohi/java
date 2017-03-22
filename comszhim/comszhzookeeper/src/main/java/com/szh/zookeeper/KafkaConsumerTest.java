package com.szh.zookeeper;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by alongsea2 on 2017/3/22.
 */
public class KafkaConsumerTest {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Partition: " + record.partition() + " Offset: " + record.offset()
                        + " Value: " + record.value() + " ThreadID: " + Thread.currentThread().getId());
            }
        }
    }
}
