package com.lianchuang.util;

/**
 * Created by Administrator on 2016/11/3.
 */
public class ResponseUtil {
    public static final String MESSAGE_ERROR  = "{\"result\":0}";
    public static final String MESSAGE_TRUE  = "{\"result\":1}";
    public static final String MESSAGE_FALSE  = "{\"result\":2}";


    public static final String MESSAGE_ADD_TRUE = "{\"status\":\"1\",\"msg\":\"添加成功\"}";
    public static final String MESSAGE_ADD_FALSE = "{\"status\":\"2\",\"msg\":\"添加失败\"}";
    public static final String MESSAGE_ADD_ERROR = "{\"status\":\"0\",\"msg\":\"添加异常!!请联系管理员\"}";

    public static final String MESSAGE_UP_TRUE = "{\"status\":\"1\",\"msg\":\"修改成功\"}";
    public static final String MESSAGE_UP_FALSE = "{\"status\":\"2\",\"msg\":\"修改失败\"}";
    public static final String MESSAGE_UP_ERROR = "{\"status\":\"0\",\"msg\":\"修改异常!!请联系管理员\"}";


    public static final String MESSAGE_DEL_TRUE = "{\"status\":\"1\",\"msg\":\"删除成功\"}";
    public static final String MESSAGE_DEL_FALSE = "{\"status\":\"2\",\"msg\":\"删除失败\"}";
    public static final String MESSAGE_DEL_ERROR = "{\"status\":\"0\",\"msg\":\"删除异常!!请联系管理员\"}";

}
