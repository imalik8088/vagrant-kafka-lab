package io.github.ineedcode.Producer;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class KafkaProNewApi {

    public static void send() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka-1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        String data="{taskId: 164,tokenArray: [" +
                "\"308187f0904411e6830419bbff96e759\",\"dsarewfafas\",\"3erdasd\"]" +
                "}";
        ProducerRecord<String,String> record = new ProducerRecord<>("simple-producer-consumer","1", data);
            producer.send(record,
                    (metadata, e) -> {
                        if(e != null){
                            e.printStackTrace();
                        }
                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
                    });
            TimeUnit.SECONDS.sleep(1);
//            producer.send(new ProducerRecord<>("bar", Integer.toString(i), Integer.toString(i)));
        producer.close();

    }

    public static void main(String[] args) throws InterruptedException {
        send();
    }
}
