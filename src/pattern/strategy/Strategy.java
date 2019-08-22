package pattern.strategy;

/**
 * 计算
 *
 * @author lwk
 * @date 2019-08-22 10:54
 */
public interface Strategy {
    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @return
     */
    int calculate(int num1, int num2);
}
