package zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author lwk
 * @date 2019-12-10 15:44
 */
public class ZookeeperMain {
    private static String connectString = "10.240.169.161:2181";
    private static CuratorFramework client;
    private static String root = "/leb/lock";

    static {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        // 永久root节点
        client = CuratorFrameworkFactory.newClient(connectString, 10000, 60000, retryPolicy);
        client.start();
    }

    public static void main(String[] args) {

        try {
            Stat stat = client.checkExists().forPath(root);
            if (stat == null) {
                String path = createNode();
                System.out.println(path);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }

    private static String createNode() {
        String path = null;
        try {
            path = client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(root);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
