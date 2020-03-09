package kafka;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author lwk
 * @date 2019-11-28 16:22
 */
public class KafkaProducerTest {
    private static String topic = "streams-plaintext-input";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.240.169.161:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i < 10; i++) {
//            producer.send(new ProducerRecord<>(topic, RandomStringUtils.randomAlphabetic(4)));
//        }
        producer.send(new ProducerRecord<>(topic, RandomStringUtils.randomNumeric(8),
                RandomStringUtils.randomAlphabetic(2) + " " + RandomStringUtils.randomAlphabetic(4)));
        producer.close();
    }
}
