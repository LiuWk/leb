package thread.forkjoin;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分隔计算，连续数
 *
 * @author lwk
 * @date 2019-05-05 11:15
 */
public class TestForkJoinTask extends RecursiveTask<BigDecimal> {
    private BigDecimal threshold = BigDecimal.valueOf(10000);
    private BigDecimal startNum;
    private BigDecimal endNum;

    public TestForkJoinTask(BigDecimal startNum, BigDecimal endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    protected BigDecimal compute() {
        // 没有达到阈值
        if (endNum.subtract(startNum).compareTo(threshold) <= 0) {
            // 直接计算
            BigDecimal total = BigDecimal.ZERO;
            for (BigDecimal i = startNum; i.compareTo(endNum) <= 0; i = i.add(BigDecimal.ONE)) {
                total = i.add(total);
            }
            return total;
        }

        BigDecimal mid = startNum.add(endNum).divide(BigDecimal.valueOf(2), BigDecimal.ROUND_CEILING);

        TestForkJoinTask left = new TestForkJoinTask(startNum, mid);
        TestForkJoinTask right = new TestForkJoinTask(mid.add(BigDecimal.ONE), endNum);

        left.fork();
        right.fork();

        return left.join().add(right.join());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<BigDecimal> rel = pool.submit(new TestForkJoinTask(BigDecimal.ZERO, BigDecimal.valueOf(10000001)));
        System.out.println(rel.get());
    }
}
