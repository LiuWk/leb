package spring.aop.javassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 在 Javassist 中，类 Javaassit.CtClass 表示 class 文件。
 * 一个 GtClass (编译时类）对象可以处理一个 class 文件，ClassPool是 CtClass 对象的容器。
 * 它按需读取类文件来构造 CtClass 对象，并且保存 CtClass 对象以便以后使用。
 */
public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException, CannotCompileException {
        ClassPool classPool = ClassPool.getDefault();
        ClassPath classPath = classPool.appendClassPath("D:/git/lab/src/spring//aop//javassist");
        CtClass ctClass = classPool.get("spring.aop.javassist.Person");
        Object person = ctClass.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "张三");
        // 输出值
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);
    }
}
