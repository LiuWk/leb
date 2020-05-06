package zookeeper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lwk
 */ //@ConfigurationProperties(prefix = "zookeeper")
@Component
public class ZookeeperProperties {
    @Value("${zookeeper.zkServer}")
    private String zkServer;
    @Value("${zookeeper.zkTimeout}")
    private int zkTimeout;
    @Value("${zookeeper.retrySleepTime}")
    private int retrySleepTime;
    @Value("${zookeeper.retryMaxRetry}")
    private int retryMaxRetry;

    public String getZkServer() {
        return zkServer;
    }

    public void setZkServer(String zkServer) {
        this.zkServer = zkServer;
    }

    public int getZkTimeout() {
        return zkTimeout;
    }

    public void setZkTimeout(int zkTimeout) {
        this.zkTimeout = zkTimeout;
    }

    public int getRetrySleepTime() {
        return retrySleepTime;
    }

    public void setRetrySleepTime(int retrySleepTime) {
        this.retrySleepTime = retrySleepTime;
    }

    public int getRetryMaxRetry() {
        return retryMaxRetry;
    }

    public void setRetryMaxRetry(int retryMaxRetry) {
        this.retryMaxRetry = retryMaxRetry;
    }
}
