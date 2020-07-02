package kafka.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class KafkaProducerTemplate<K, V> {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerTemplate.class);
    private String brokerList;
    private String serializerClass;
    private String partitionerClass;
    private String requiredAcks;
    private String producerType;
    private KafkaProducer<K, V> producer;

    public KafkaProducerTemplate() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("--lab: close producer Thread[{}]", Thread.currentThread().getId());
            if (producer != null) {
                producer.close();
            }
            LOGGER.info("--lab: close executor Thread[{}]", Thread.currentThread().getId());
        }));
    }

    public void init() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", brokerList);
        properties.put("serializer.class", serializerClass);
        properties.put("partitioner.class", partitionerClass);
        properties.put("request.required.acks", requiredAcks);
        properties.put("producer.type", producerType);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(properties);
    }

    public void sendSync(String topicName, K key, V message) {
        ProducerRecord<K, V> data = new ProducerRecord<>(topicName, key, message);
        producer.send(data);
    }

    public void send(String topicName, K key, V message) {
        ProducerRecord<K, V> data = new ProducerRecord<>(topicName, key, message);
        producer.send(data, (recordMetadata, e) -> {
            if (e != null) {
                LOGGER.error("send exception:{}", e.getStackTrace());
            } else {
                LOGGER.info("The offset of the record we just sent is: {}", recordMetadata.offset());
            }
        });
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getSerializerClass() {
        return serializerClass;
    }

    public void setSerializerClass(String serializerClass) {
        this.serializerClass = serializerClass;
    }

    public String getPartitionerClass() {
        return partitionerClass;
    }

    public void setPartitionerClass(String partitionerClass) {
        this.partitionerClass = partitionerClass;
    }

    public String getRequiredAcks() {
        return requiredAcks;
    }

    public void setRequiredAcks(String requiredAcks) {
        this.requiredAcks = requiredAcks;
    }

    public String getProducerType() {
        return producerType;
    }

    public void setProducerType(String producerType) {
        this.producerType = producerType;
    }
}
