package kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class KafkaConsumerTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerTemplate.class);
    private String brokerList;
    private String groupID;
    private String autoCommitInterval = "1000";
    private String autoOffsetReset = "latest";
    private KafkaConsumer<String, String> consumer;
    private ExecutorService executorService;
    private AtomicBoolean isRunning = new AtomicBoolean(true);

    /**
     * 注册shutdownhook，程序关闭是回调关闭资源
     */
    public KafkaConsumerTemplate() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOGGER.info("--lab: close consumer Thread[{}]", Thread.currentThread().getId());
            stop();
            LOGGER.info("--lab: close executor Thread[{}]", Thread.currentThread().getId());
        }));
    }

    /**
     * 初始化kafka消费者
     */
    private void init() {
        LOGGER.info("Start init kafka consumer.....");
        try {
            Properties props = new Properties();
            props.setProperty("bootstrap.servers", brokerList);
            props.setProperty("group.id", groupID);
            props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            props.setProperty("enable.auto.commit", "true");
            props.setProperty("auto.commit.interval.ms", autoCommitInterval);
            props.setProperty("auto.offset.reset", autoOffsetReset);
            props.setProperty("rebalance.backoff.ms", "5000");
            props.setProperty("rebalance.max.retries", "10");
            consumer = new KafkaConsumer<>(props);
        } catch (Exception e) {
            LOGGER.error("Start init kafka exception", e);
        }
        LOGGER.info("Init kafka consumer OK");
    }

    /**
     * 单消费实例，多线程业务处理，不能保证消费的消息的顺序
     *
     * @param topicName
     * @param numThreads
     * @param callback
     */
    public void subscribe(String topicName, int numThreads, final KafkaSubscribeCallback callback) {
        LOGGER.info("subscribe start... topic:{}, threads:{}", topicName, numThreads);
        try {
            if (consumer == null) {
                System.out.println("consumer is null");
                return;
            }
            consumer.subscribe(Arrays.asList(topicName));
            // demo 暂时这么写线程池
            executorService = Executors.newFixedThreadPool(numThreads);
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (final ConsumerRecord<String, String> record : records) {
                    executorService.submit(() -> {
                        System.out.printf("tid = %s, offset = %d, key = %s, value = %s, partion = %s %n", Thread.currentThread().getName(),
                                record.offset(), record.key(), record.value(), record.partition());
                        callback.execute(record.value());
                    });
                }
            }

        } catch (Exception e) {
            LOGGER.error("KafkaConsumerTemplate >> subscribe Get TopicName [{}] kafkaDate Error:{}", topicName, e);
        } finally {
        }
    }

    /**
     * 单consumer实例，单业务处理线程
     *
     * @param topicName
     * @param callback
     */
    public void subscribe2(String topicName, final KafkaSubscribeCallback callback) {
        LOGGER.info("subscribe2 start... topic:{}", topicName);
        try {
            if (consumer == null) {
                System.out.println("consumer is null");
                return;
            }
            consumer.subscribe(Arrays.asList(topicName));
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (final ConsumerRecord<String, String> record : records) {
                    System.out.printf("tid = %s, offset = %d, key = %s, value = %s, partion = %s %n", Thread.currentThread().getName(),
                            record.offset(), record.key(), record.value(), record.partition());
                    callback.execute(record.value());
                }
            }

        } catch (Exception e) {
            LOGGER.error("KafkaConsumerTemplate >> subscribe Get TopicName [{}] kafkaDate Error:{}", topicName, e);
        }
    }

    /**
     * 以分区为维度消费数据，单消费实例消费所有分区，多线程业务处理
     *
     * @param topicName
     * @param callback
     */
    public void subscribe3(String topicName, int numThreads, final KafkaSubscribeCallback callback) {
        LOGGER.info("subscribe2 start... topic:{}", topicName);
        try {
            if (consumer == null) {
                System.out.println("consumer is null");
                return;
            }
            consumer.subscribe(Arrays.asList(topicName));
            executorService = Executors.newFixedThreadPool(numThreads);
            while (isRunning.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (TopicPartition topicPartition : records.partitions()) {
                    executorService.submit(() -> {
                        for (final ConsumerRecord<String, String> record : records.records(topicPartition)) {
                            System.out.printf("tid = %s, offset = %d, key = %s, value = %s, partion = %s %n", Thread.currentThread().getName(),
                                    record.offset(), record.key(), record.value(), record.partition());
                            callback.execute(record.value());
                        }
                    });
                }
            }

        } catch (Exception e) {
            LOGGER.error("KafkaConsumerTemplate >> subscribe Get TopicName [{}] kafkaDate Error:{}", topicName, e);
        }
    }

    public void stop() {
        isRunning.set(false);
        if (consumer != null) {
            consumer.close();
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public final void setAutoCommitInterval(String autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public final void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public String getGroupID() {
        return groupID;
    }

    public String getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public KafkaConsumer getConsumer() {
        return consumer;
    }

    public void setConsumer(KafkaConsumer consumer) {
        this.consumer = consumer;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }
}
