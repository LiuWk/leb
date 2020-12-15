package spring.aop;

/**
 * @author lwk
 * @date 2019-08-29 15:00
 */
public class Dog implements Animal {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void bark() {
        System.out.println(name + "旺旺！");
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
