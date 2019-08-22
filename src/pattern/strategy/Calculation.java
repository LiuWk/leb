package pattern.strategy;

/**
 * 计算类入口
 *
 * @author lwk
 * @date 2019-08-22 10:59
 */
public class Calculation {
    private Strategy strategy;

    public Calculation(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int num1, int num2) {
        return strategy.calculate(num1, num2);
    }
}
