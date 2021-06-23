package team.rookie.api.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ReturnMapUtil
 * @Description TODO 对返回数据 Map进行封装
 * @Author tran
 * @Date 2021/6/17 10:47
 * @Version 1.0
 **/
public class ReturnMapUtil {

    /**
     * @Author tran
     * @Description //TODO 最基本的返回
     * @Date 10:48 2021/6/17
     * @Param [code, msg] code: 状态码 msg： 返回结果信息
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> printf(Integer code,String msg){
        HashMap<String, Object> data = new HashMap<>();
        data.put("code",code);
        data.put("msg",msg);
        return data;
    }

    /**
     * @Author tran
     * @Description //TODO 带数据的返回
     * @Date 10:50 2021/6/17
     * @Param [code, msg, data]
     *      code: 状态码
     *      msg：返回结果信息
     *     data: 数据
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> printf(Integer code,String msg,Object data){
        Map<String, Object> map = printf(code, msg);
        map.put("data",data);
        return map;
    }


    /**
     * @Author tran
     * @Description //TODO 对 layui 的表格进行封装
     * @Date 10:54 2021/6/17
     * @Param [code, count, msg, data]
     *            code: 状态码
     *            msg：返回结果信息
     *            data: 数据
     *            count : 数据的总条数
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> printf(Integer code,Long count,String msg,Object data){
        Map<String, Object> map = printf(code, msg, data);
        map.put("count",count);
        return map;
    }

    /**
     * @Author tran
     * @Description //TODO 对 layui 的表格进行封装
     * @Date 10:54 2021/6/17
     * @Param [code, count, msg, data]
     *            code: 状态码
     *            msg：返回结果信息
     *            data: 数据
     *            count : 数据的总条数
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> printf(Integer code,Integer count,String msg,Object data){
        Map<String, Object> map = printf(code, msg, data);
        map.put("count",count);
        return map;
    }
}
