package pattern.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lwk
 * @date 2019-07-15 14:32
 */
public class Test {
    public static void target(int i) {
        // 空方法
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) {
//        try {
//            Class<?> clz = Class.forName("pattern.reflect.Test");
//            Method mods = clz.getMethod("target", int.class);
//            for (int i = 0; i < 20; i++) {
//                mods.invoke(null,i);
//            }
//        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

        System.out.println(System.getProperty("java.reflect.inflationThreshold"));
        System.out.println(System.getProperty("java.version"));
        String str = null;
        t1("");
        t1(null,null);
    }



    public static void main1(String[] args) {
        try {
            Class<?> klass = Class.forName("pattern.reflect.Test");
            Method method = klass.getMethod("target", int.class);
            Method method2 = klass.getMethod("target", int.class);
            System.out.println(method == method2);

            long current = System.currentTimeMillis();
            for (int i = 1; i <= 2_000_000_000; i++) {
                if (i % 100_000_000 == 0) {
                    long temp = System.currentTimeMillis();
                    System.out.println(temp - current);
                    current = temp;
                }
                method.invoke(null, 128);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void t1(String str){
        System.out.println("string str");
    }

    public static void t1(String... strs){
        System.out.println(strs.getClass().getTypeName());
        System.out.println("string... str");
    }

//    public static void t1(String[] strs){
//        System.out.println("string[] str");
//    }


}
