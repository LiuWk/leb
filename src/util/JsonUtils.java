package util;

import java.nio.charset.Charset;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 北京掌中彩信息科技有限公司源代码，版权归北京掌中彩信息科技有限公司所有。
 * 
 * 项目名称 : common-util
 * 创建日期 : 2015年11月26日
 * 类  描  述 : alibaba.fastjson:对json格式数据转换工具类
 * 修改历史 : 
 *     1. [2015年11月26日]创建文件 by zheng.p
 */
public class JsonUtils {
    private static final String DATE_FORMAT = "yyyyMMddHHmmss";
    
    public String toJson() {
        return toJson(false);
    }

    public String toJson(final boolean prettyFormat) {
        return toJson(this, prettyFormat);
    }


    /**
     * 
     * 对象转成Json串
     * 
     * @param obj 转换对象
     * @param prettyFormat 是否需要格式化
     * @return json字符串
     */
    public static String toJson(final Object obj, boolean prettyFormat) {
        return JSON.toJSONString(obj, prettyFormat);
    }
    
//    /**
//     * 自定义时间格式 
//     * 
//     * @param obj 转换对象
//     * @param dateFormat 日期格式化，默认为yyyyMMddHHmmss
//     * @return json字符串
//     */
//    public static String toJson(final Object obj , String dateFormat){
//        mapping.put(Date.class, new SimpleDateFormatSerializer(null == dateFormat ? DATE_FORMAT : dateFormat));
//        return JSON.toJSONString(obj , mapping);
//    }
    
    /**
     * 自定义数据过滤器
     * 
     * @param obj 转换对象
     * @param filter 数据过滤器
     * @return json字符串
     */
//    public static String toJsonUseFilter(final Object obj, SerializeFilter filter){
//        //默认使用JSON_VALUE_FILTER
//        return JSON.toJSONString(obj , null == filter ? JSON_VALUE_FILTER : filter);
//    }

    /**
     * 
     * Json串转成对象
     * 
     * @param json 字符串
     * @param classOfT class对象
     * @return 实体类对象
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return JSON.parseObject(json, classOfT);
    }

    /**
     * 根据json字符串转换成json对象
     * 
     * @param json 字符串
     * @return json对象
     * @author zheng.p
     * @date 2015年11月25日 下午5:08:33
     */
    public static JSONObject fromJson(String json){
        return JSON.parseObject(json);  
    }

    public byte[] encode() {
        final String json = this.toJson();
        if (json != null) {
            return json.getBytes();
        }
        return null;
    }


    public static byte[] encode(final Object obj) {
        final String json = toJson(obj, false);
        if (json != null) {
            return json.getBytes(Charset.forName("UTF-8"));
        }
        return null;
    }


    public static <T> T decode(final byte[] data, Class<T> classOfT) {
        final String json = new String(data, Charset.forName("UTF-8"));
        return fromJson(json, classOfT);
    }

}

