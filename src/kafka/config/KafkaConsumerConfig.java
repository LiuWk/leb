package kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerConfig {
    @Value("${sync.kafka.brokerList}")
    private String brokerList;
    @Value("${sync.kafka.groupId}")
    private String groupID;

    @Bean(initMethod = "init")
    public KafkaConsumerTemplate kafkaConsumerTemplateBean() {
        KafkaConsumerTemplate kafkaConsumerTemplate = new KafkaConsumerTemplate();
        kafkaConsumerTemplate.setBrokerList(brokerList);
        kafkaConsumerTemplate.setGroupID(groupID);
        return kafkaConsumerTemplate;
    }
}
