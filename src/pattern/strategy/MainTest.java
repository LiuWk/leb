package pattern.strategy;

/**
 * @author lwk
 * @date 2019-08-22 10:44
 */
public class MainTest {
    public static void main(String[] args) {
        Calculation c1 = new Calculation(new AddStrategy());
        Calculation c2 = new Calculation(new MinusStrategy());

        System.out.println(c1.calculate(10, 20));
        System.out.println(c2.calculate(10, 20));
    }
}
