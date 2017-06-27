package io.github.ineedcode.Simple;

import org.apache.kafka.clients.producer.*;

import java.text.*;
import java.util.*;

public class SimpleProducer {

   public static void main(String[] args) {

      Properties props = new Properties();
      props.put("bootstrap.servers", "kafka-1:9092, kafka-2:9092, kafka-3:9092");
      props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
      props.put("acks", "1");
      props.put("batch.size", 500);
//      props.put("compression.type", "gzip");


      KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
      DateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
      String topic = "simple-producer-consumer";

      int numberOfRecords = 10000; // number of records to send
      long sleepTimer = 5000; // how long you want to wait before the next record to be sent

      try {
         for (int i = 0; i < numberOfRecords; i++)
            myProducer.send(
                    new ProducerRecord<String, String>(
                            topic, String.format("Message: %s  sent at %s",
                            Integer.toString(i * (new Random().nextInt(10))),
                            dtFormat.format(new Date())
                    ))
            );
         Thread.sleep(sleepTimer);
         System.out.println("============> "+ numberOfRecords + " MESSAGES PRODUCED");
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         myProducer.close();
      }

   }
}
