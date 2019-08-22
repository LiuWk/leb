package pattern.strategy;

/**
 * 加法策略
 * @author lwk
 * @date 2019-08-22 10:57
 */
public class MinusStrategy implements Strategy {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
