package com.jn.utils;

/**
 * com.jn.utils.MainUtil
 *
 * @author eleven
 * @date 2019/07/18
 */
public class MainUtil {

    /**
     * 是否非数字
     *
     * @param t
     * @return
     */
    public static <T> boolean isNotNumber(T t) {
        return !isNumber(t);
    }

    /**
     * 是否为数字
     *
     * @param t
     * @return
     */
    public static <T> boolean isNumber(T t) {
        return t instanceof Number;
    }
}
