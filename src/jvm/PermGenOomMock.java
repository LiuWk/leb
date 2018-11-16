package jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * PermGen（永久代）
 * <p>
 * 　　绝大部分 Java 程序员应该都见过 "java.lang.OutOfMemoryError: PermGen space "这个异常。
 * 这里的 “PermGen space”其实指的就是方法区。不过方法区和“PermGen space”又有着本质的区别。
 * 前者是 JVM 的规范，而后者则是 JVM 规范的一种实现，并且只有 HotSpot 才有 “PermGen space”，
 * 而对于其他类型的虚拟机，如 JRockit（Oracle）、J9（IBM） .并没有“PermGen space”。
 * 由于方法区主要存储类的相关信息，所以对于动态生成类的情况比较容易出现永久代的内存溢出。
 * 最典型的场景就是，在 jsp 页面比较多的情况，容易出现永久代内存溢出。
 *
 * @author lwk
 * @createTime 2018-11-16 9:46
 **/
public class PermGenOomMock{
    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("jvm.Test");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Test {
}