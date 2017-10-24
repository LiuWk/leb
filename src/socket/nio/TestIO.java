package socket.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月26日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月26日]创建文件 by lwk
 */
public class TestIO {
    public static void main(String[] args) {
        FileInputStream is = null;
        BufferedInputStream bi = null;
        FileReader r = null;
        try {
            //            is = new FileInputStream("F:/t_station_location.sql");
            //            bi = new BufferedInputStream(is);
            //            byte[] b = new byte[1024];
            //            int i = 0;
            //            while((i = bi.read(b)) != -1){
            //                
            //                System.out.println(new String(b,"utf-8"));
            //            }
            r = new FileReader("F:/t_station_location.sql");

            char[] b = new char[1024];
            int i = 0;
            while ((i = r.read(b)) != -1) {

                //                System.out.println((char) i);
                System.out.println(new String(b));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
