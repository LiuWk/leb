package spring.aop.aspect;

/**
 * 需要手动选择aj编译器，不能用javac
 * java -jar aspectj-1.9.6.jar安装ajdk
 */
public class MainTest {
    public static void main(String[] args) {
        HelloAspect helloAspect = new HelloAspect();
        helloAspect.sayHello();
    }
}
    