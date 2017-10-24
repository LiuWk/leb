package spring.aop.validate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //① 指定测试用例运行器  
@ContextConfiguration(locations = {"classpath:/application-bean.xml"})
public class UserTest {

    @Autowired
    User user;
    
//    @org.junit.Test
//    public void test() {
//        fail("Not yet implemented");
//    }
    
    @Test
    public void user(){
        System.out.println(user.toString());
        System.out.println(user.getUrl());
    }

}
