/**
 * 
 */
package pattern.singleton;

/**
 * @author lwk
 *
 */
/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年7月4日
 * 类  描  述 : 双重if判断实现单例
 * 修改历史 : 
 *     1. [2017年7月4日]创建文件 by lwk
 */
public class Goalkeeper {
    private static Goalkeeper GOAL_KEEPER = null;

    public static Goalkeeper getInstance() {
        if (GOAL_KEEPER == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Goalkeeper.class) {
                if (GOAL_KEEPER == null) {
                    GOAL_KEEPER = new Goalkeeper();
                }
            }
        }
        return GOAL_KEEPER;
    }
    public static Goalkeeper getInstance(String name) {
        if (GOAL_KEEPER == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Goalkeeper.class) {
                if (GOAL_KEEPER == null) {
                    GOAL_KEEPER = new Goalkeeper(name);
                }
            }
        }
        return GOAL_KEEPER;
    }

    /**
     *  防止直接new对象
     */
    private Goalkeeper() {
        super();
    }

    public Goalkeeper(String name) {
        System.out.println("球员姓名：" + name);
    }

}
