package spring.aop;

/**
 * @author lwk
 * @date 2019-08-29 15:01
 */
public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    @Override
    public void bark() {
        System.out.println(name + "喵喵");
    }

    @Override
    public void eat() {
        System.out.println(name + "吃吃！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
