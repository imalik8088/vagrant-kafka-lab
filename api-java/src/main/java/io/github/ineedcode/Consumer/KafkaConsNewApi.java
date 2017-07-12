package io.github.ineedcode.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;


public class KafkaConsNewApi {

   public static void consumer() {
      Properties props = new Properties();
      props.put("bootstrap.servers", "kafka-1:9092,kafka-2:9092,kafka-3:9092");
      props.put("group.id", "java-simiple-consumer");
      props.put("enable.auto.commit", "true");
      props.put("auto.commit.interval.ms", "1000");
      props.put("session.timeout.ms", "30000");
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

      KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
      consumer.subscribe(Arrays.asList("simple-producer-consumer"));

      while (true) {
         ConsumerRecords<String, String> records = consumer.poll(10);  //poll 100 records at a time
         for (ConsumerRecord<String, String> record : records) {
            System.out.println(record.topic() + " #" + record.offset() + " #" + record.key() + " #" + record.value());
         }
      }

   }

   public static void main(String[] args) {
      consumer();
   }
}

