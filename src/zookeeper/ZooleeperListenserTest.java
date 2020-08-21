package zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.listen.StandardListenerManager;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

@Slf4j
public class ZooleeperListenserTest {
    private static final CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("10.240.169.116:2181")
            .sessionTimeoutMs(10000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3))
            .build();
    private static final String path = "/listen-test";

    public static void main(String[] args) throws Exception {
        listener();

    }

    public static void listener() throws Exception {
        System.out.println("listener");
        client.start();
        try {
            Stat stat = client.checkExists().forPath(path);
            if (stat == null) {
                client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path);
            }
        } catch (Exception e) {
            log.error("listener e:{}", e.getMessage());
        }

//        NodeCacheListener nodeCacheListener = () -> {
//            log.info("监听事件触发");
//            log.info("重新获得节点内容为：" + nodeCache.toString());
//        }
        CuratorCache nodeCache = CuratorCache.builder(client, path).build();
        CuratorCacheListener nodeCacheListener = new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData newData) {
                log.info("监听事件触发,type:{},重新获得节点内容为 ==> newData:{},newData:{}", type,
                        new String(oldData.getData()), new String(newData.getData()));
            }
        };
        nodeCache.listenable().addListener(nodeCacheListener);
        nodeCache.start();
        StandardListenerManager.standard().addListener(nodeCacheListener);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
