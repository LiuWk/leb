package pattern.singleton;

/**
 * 单例，内部类实现方式，线程安全
 * @author lwk
 * @date 2019-07-15 10:17
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static class LazyHolder {
        static final Singleton2 INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {

    }
}