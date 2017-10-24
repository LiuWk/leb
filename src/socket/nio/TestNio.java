package socket.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年6月26日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年6月26日]创建文件 by lwk
 */
public class TestNio {
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile("F:/t_station_location.sql", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(256);//开辟缓冲区分配空间
            int i = channel.read(buf);
            while (i != -1) {
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());

                }

                buf.compact();
                i = channel.read(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
