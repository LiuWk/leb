package util;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringHelper {

    private static final Logger logger = LoggerFactory.getLogger(SpringHelper.class);

    private static ApplicationContext cx = null;

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        if(null == cx){
            synchronized(SpringHelper.class){
                if(null == cx){
                    //如果cx加载太慢，会对SpringHelper加锁，等待spring上下文加载完毕
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.getBean", "cx is null" });
                    return null;
                }
                return (T) cx.getBean(beanId);
            }
        }
        return (T) cx.getBean(beanId);
    }
    
    public static <T> T getBean(Class<T> requiredType){
        if(null == cx){
            synchronized(SpringHelper.class){
                if(null == cx){
                    //如果cx加载太慢，会对SpringHelper加锁，等待spring上下文加载完毕
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.getBean type", "cx is null" });
                    return null;
                }
                return (T) cx.getBean(requiredType);
            }
        }
        return (T) cx.getBean(requiredType);
    }
    
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        if(null == cx){
            synchronized(SpringHelper.class){
                if(null == cx){
                    //如果cx加载太慢，会对SpringHelper加锁，等待spring上下文加载完毕
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.getBean", "cx is null" });
                    return null;
                }
                return (Map<String, T>) cx.getBeansOfType(clazz);
            }
        }
        
        return (Map<String, T>) cx.getBeansOfType(clazz);
    }

    public static void init() {
        if (null == cx) {
            synchronized(SpringHelper.class){
                //避免调用两次加载时同时进入同步块儿
                if(null == cx){
                    
                    cx = new ClassPathXmlApplicationContext("classpath:/application-bean.xml");
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.init", "Spring config success" });
                }else{
                    
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.init", "Spring config repeat" });
                }
            }
        }
    }

    public static void init(String[] paths) {
        if (null == cx) {
            synchronized(SpringHelper.class){
                //避免调用两次加载时同时进入同步块儿
                if(null == cx){
                    
                    cx = new ClassPathXmlApplicationContext(paths);
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.init.paths", "Spring config success" });
                }else{
                    
                    logger.info(LogFormatUtil.getFormatTemplate(new String[] { "method", "msg" }), 
                            new String[] { "SpringHelper.init.paths", "Spring config repeat" });
                }
            }
        }
    }

    public static void init(String path) {
        init(new String[] { path });
    }

    public static ApplicationContext getApplicationContext() {
        return cx;
    }
    
    public static void setApplicationContext(ApplicationContext cx) {
        SpringHelper.cx = cx;
    }
}
