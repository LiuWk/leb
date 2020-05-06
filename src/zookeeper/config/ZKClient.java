package zookeeper.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class ZKClient {
    private final String NODE_GATEWAY = "/leb-root";
    @Autowired
    private ZookeeperProperties zookeeperProperties;
    private CuratorFramework client;

    @Bean(initMethod = "")
    public CuratorFramework getClient() {
        client = CuratorFrameworkFactory.builder()
                .connectString(zookeeperProperties.getZkServer())
                .sessionTimeoutMs(zookeeperProperties.getZkTimeout())
                .retryPolicy(new ExponentialBackoffRetry(zookeeperProperties.getRetrySleepTime(), zookeeperProperties.getRetryMaxRetry()))
                .build();
        client.start();
        return client;
    }

    public void listener() {
        try {
            Stat stat = client.checkExists().forPath(NODE_GATEWAY);
            if (stat == null) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(NODE_GATEWAY, "init".getBytes("utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NodeCache nodeCache = new NodeCache(client, NODE_GATEWAY, false);
        try {
            nodeCache.start();
        } catch (Exception e) {
            System.out.println("【启动监听缓存】异常信息：" + e.getMessage());
        }
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("[receive update notify,update ip and url!!]");
            }
        });
    }

}
