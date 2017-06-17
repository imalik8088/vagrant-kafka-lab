package io.github.ineedcode.Producer;

import org.apache.kafka.clients.producer.*;

import java.text.*;
import java.util.*;

public class ProducerApp {

    public static void main(String[] args){

        // Create the Properties class to instantiate the Consumer with the desired settings:
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka-1:9092, kafka-2:9092, kafka-3:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("buffer.memory", 33554432);
        props.put("compression.type", "none");
        props.put("retries", 0);
        props.put("batch.size", 10);
        props.put("client.id", "");
        props.put("linger.ms", 0);
        props.put("max.block.ms", 60000);
        props.put("max.request.size", 1048576);
        props.put("partitioner.class", "org.apache.kafka.clients.producer.internals.DefaultPartitioner");
        props.put("request.timeout.ms", 30000);
        props.put("timeout.ms", 30000);
        props.put("max.in.flight.requests.per.connection", 5);
        props.put("retry.backoff.ms", 5);

        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);
        DateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
        String topic = "akhlaq";

        int numberOfRecords = 1000; // number of records to send
        long sleepTimer = 0; // how long you want to wait before the next record to be sent

        try {
                for (int i = 0; i < numberOfRecords; i++ )
                    myProducer.send(new ProducerRecord<String, String>(topic, String.format("Message: %s  sent at %s", Integer.toString(i), dtFormat.format(new Date()))));
                    Thread.sleep(sleepTimer);
                     Thread.sleep(new Random(5000).nextLong()); // use if you want to randomize the time between record sends
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myProducer.close();
        }

    }
}
