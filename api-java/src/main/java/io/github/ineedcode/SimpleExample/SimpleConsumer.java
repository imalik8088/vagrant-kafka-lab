package io.github.ineedcode.SimpleExample;

import org.apache.kafka.clients.consumer.*;

import java.util.*;

public class SimpleConsumer {

   public static void main(String[] args) {

      Properties props = new Properties();
      props.put("bootstrap.servers", "kafka-1:9092,kafka-2:9092,kafka-3:9092");
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("group.id", UUID.randomUUID().toString());
      props.put("auto.offset.reset", "earliest");
      props.put("enable.auto.commit", true);


      // Create a KafkaConsumer instance and configure it with properties.
      KafkaConsumer<String, String> myConsumer = new KafkaConsumer<String, String>(props);

      // Create a topic subscription list:
      ArrayList<String> topics = new ArrayList<String>();
      topics.add("simple-producer-consumer");
      myConsumer.subscribe(topics);

      // Retrieves the topic subscription list from the SubscriptionState internal object:
      Set<String> subscribedTopics = myConsumer.subscription();

      // Print the topic subscription list:
      printSet(subscribedTopics);

      // Start polling for messages:
      try {
         while (true) {
            ConsumerRecords records = myConsumer.poll(1000);
            printRecords(records);
         }
      } finally {
         myConsumer.close();
      }

   }

   private static void printSet(Set<String> topics) {
      if (topics.isEmpty()) {
         System.out.println("I am not subscribed to anything yet...");
      } else {
         System.out.println("I am subscribed to the following topics:");
         for (String item : topics) System.out.println(item);
         System.out.println("");
      }
   }

   private static void printRecords(ConsumerRecords<String, String> records) {
      for (ConsumerRecord<String, String> record : records) {
         System.out.println(
                 String.format("Topic: %s \t Partition: %d \t Offset: %d \t Key: %s \t Value: %s",
                         record.topic(), record.partition(), record.offset(), record.key(), record.value()
                 )
         );
      }
   }
}
