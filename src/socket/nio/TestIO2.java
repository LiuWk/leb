package socket.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class TestIO2 {
    public static void main(String[] args) {
        FileInputStream is = null;
        FileOutputStream os = null;
        long start = System.currentTimeMillis();
        try {
            is = new FileInputStream("F:/t_station_location.sql" );
            os = new FileOutputStream("F:/t_station_location_cp.sql");
            int i = 0;
            while ((i = is.read()) != -1) {
//                System.out.print((char)i);
                os.write(i);
            }
            
            System.out.println("复制文件完毕："+(System.currentTimeMillis()-start)+" 毫秒");
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
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
