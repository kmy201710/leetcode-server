package com.leetcode.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 判空工具类  https://blog.csdn.net/shixinbing/article/details/84065690
 *
 * @Author hhe
 * @Date 2021/2/4 13:51
 * @Description
 */
public class EmptyUtils {

    private EmptyUtils() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }

    /**
     * 功能描述: Object 等于空
     *
     * @return boolean
     * @date 2018/11/01 15:06
     * @Param [obj]
     */
    public static boolean isEmpty(Object obj) {
        return obj == null;
    }


    /**
     * 功能描述: Object 不等于空
     *
     * @return boolean
     * @date 2018/11/01 15:07
     * @Param [obj]
     */
    public static boolean isNotEmpty(Object obj) {
        return obj != null;
    }

    public static boolean isEmpty(Map map) {
        return map == null;
    }

    public static boolean isNotEmpty(Map map) {
        return map != null;
    }

    /**
     * 功能描述: str 等于空
     *
     * @return boolean
     * @date 2018/11/01 15:03
     * @Param [str]
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str) || (str.trim().length() == 0));
    }


    /**
     * 功能描述: str 不等于空
     *
     * @return boolean
     * @date 2018/11/01 15:05
     * @Param [str]
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && !str.equals(""));
    }

    /**
     * 功能描述: int数字类型为空
     *
     * @return boolean
     * @date 2018/11/01 15:25
     * @Param [num]
     */
    public static boolean isEmpty(Integer num) {
        return num == null || num == 0;
    }

    /**
     * 功能描述: int数字类型不为空
     *
     * @return boolean
     * @date 2018/11/01 15:25
     * @Param [num]
     */
    public static boolean isNotEmpty(Integer num) {
        return num != null && num != 0;
    }


    /**
     * 功能描述: 对象数组为空
     *
     * @return boolean
     * @date 2018/11/01 15:09
     * @Param [strings]
     */
    public static boolean isEmpty(Object[] obj) {
        return ((obj == null) || (obj.length == 0));
    }


    /**
     * 功能描述: 对象数组不为空
     *
     * @return boolean
     * @date 2018/11/01 15:23
     * @Param [strings]
     */
    public static boolean isNotEmpty(Object[] obj) {
        return ((obj != null) && (obj.length > 0));
    }


    /**
     * 功能描述: collection集合为空
     *
     * @return boolean
     * @date 2018/11/01 15:27
     * @Param [conn]
     */
    public static boolean isEmpty(Collection<?> conn) {
        return ((conn == null) || (conn.size() <= 0));
    }

    /**
     * 功能描述: collection集合不为空
     *
     * @return boolean
     * @date 2018/11/01 15:28
     * @Param [conn]
     */
    public static boolean isNotEmpty(Collection<?> conn) {
        return ((conn != null) && (conn.size() > 0));
    }

    /**
     * 功能描述: byte数组为空
     *
     * @return boolean
     * @date 2018/11/01 15:29
     * @Param [bys]
     */
    public static boolean isEmpty(byte[] bys) {
        return ((bys == null) || (bys.length == 0));
    }

    /**
     * 功能描述: byte数组不为空
     *
     * @return boolean
     * @date 2018/11/01 15:30
     * @Param [bys]
     */
    public static boolean isNotEmpty(byte[] bys) {
        return ((bys != null) && (bys.length > 0));
    }

    /**
     * 功能描述: long类型为空
     *
     * @return boolean
     * @date 2018/11/01 15:30
     * @Param [l]
     */
    public static boolean isEmpty(Long l) {
        return ((l == null) || (l.longValue() == 0L));
    }


    /**
     * 功能描述: long类型不为空
     *
     * @return boolean
     * @date 2018/11/01 15:30
     * @Param [l]
     */
    public static boolean isNotEmpty(Long l) {
        return ((l != null) && (l.longValue() > 0L));
    }


/*    public static void main(String[] args) {
        Object object = null;
        String str=null;
        String[] strArr = {};
        boolean empty = EmptyUtils.isEmpty(object);
        boolean strBol = EmptyUtils.isEmpty(str);
        boolean strArrBol = EmptyUtils.isEmpty(strArr);
        System.out.println(strBol);
        System.out.println("字符数组：" + strArrBol);
    }*/
}