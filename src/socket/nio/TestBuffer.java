package socket.nio;

import java.nio.IntBuffer;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年8月22日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年8月22日]创建文件 by lwk
 */
public class TestBuffer {

    /**
     * //TODO 添加方法功能描述
     * @param args
     * 2017年8月22日 by lwk 
     */
    public static void main(String[] args) {
       IntBuffer buf = IntBuffer.allocate(5);
       System.out.println(buf);
       buf.put(1);
       System.out.println(buf);
       buf.put(2);
       System.out.println(buf);
       buf.put(3);
       System.out.println(buf);
       buf.put(3);
       System.out.println(buf);
       buf.flip();
       System.out.println(buf);
    }

}
