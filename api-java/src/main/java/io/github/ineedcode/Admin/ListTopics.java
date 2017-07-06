package io.github.ineedcode.Admin;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

import java.util.*;

public class ListTopics {
   //http://www.programcreek.com/java-api-examples/index.php?api=kafka.admin.AdminUtils
   public static void main(String[] args) {


      Map<String, List<PartitionInfo>> topics;

      Properties props = new Properties();
      props.put("bootstrap.servers", "kafka-1:9092,kafka-2:9092,kafka-3:9092");
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

      topics = consumer.listTopics();

      System.out.println("******************************************");
      System.out.println("          L I S T    T O P I C S          ");
      System.out.println("******************************************\n");

      for (Map.Entry<String, List<PartitionInfo>> topic : topics.entrySet()) {
         System.out.println("Topic: "+ topic.getKey());
         System.out.println("Value: " + topic.getValue() + "\n");
      }

   }
}
