package util;

public class LogFormatUtil {

    /**
     * 
     * 获取格式化模板
     * @param args
     * @return
     */
    public static String getFormatTemplate(String... args) {
        if (args == null) {
            return "";
        }
        StringBuilder _formatStr = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            _formatStr.append(args[i]);
            _formatStr.append(" = ");
            _formatStr.append("{");
            _formatStr.append(i);
            _formatStr.append("} ");
        }
        return _formatStr.toString();
    }
    /**
     * 
     * 格式化日志参数
     * @param args 
     * @param objs 
     * @return
     * 2015年10月21日 by ziqiang.zhang
     */
    public static String getFormatMsg(String[] args, Object[] objs) {

        if (args == null) {
            return "";
        }
        StringBuilder _formatStr = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            _formatStr.append(args[i]);
            _formatStr.append(" = ");
            _formatStr.append("{");
            _formatStr.append(objs[i]);
            _formatStr.append("} ");
        }
        return _formatStr.toString();
    }

    public static void main(String[] args) {
        String[] array = new String[] { "aaa", "bbb", "ccc" };
        System.out.println(getFormatTemplate(array));
    }

}
