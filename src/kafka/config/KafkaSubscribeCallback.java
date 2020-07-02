package kafka.config;


public interface KafkaSubscribeCallback {

    void execute(String msg);
    
}
