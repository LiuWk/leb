package spring.aop.validate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * leb测试用源代码
 * <p>
 * 项目名称 : design_patterns
 * 创建日期 : 2017年5月18日
 * 类  描  述 : 测试自定义注解
 * 修改历史 :
 * 1. [2017年5月18日]创建文件 by lwk
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/application-bean.xml");
        User user = (User) context.getBean("user");
//		User user = new User();
        user.setName("qqq");
        user.setPhone("144");
        System.out.println(user.toString());
//		List<String> validate = validate(user);
//
//		for(String str : validate){
//			System.out.println(str);
//		}

    }

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> List<String> validate(T t) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        List<String> messageList = new ArrayList<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            messageList.add(constraintViolation.getMessage());
        }
        return messageList;
    }
}
