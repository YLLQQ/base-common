package com.jn.utils;

import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * com.jn.utils.StringUtil
 *
 * @author eleven
 * @date 2019/07/18
 */
public class StringUtil {

    /**
     * 用0填充数字
     *
     * @param integer
     * @return
     */
    public static String formatIntWithZero(int integer) {
        StringBuilder stringBuilder = new StringBuilder(6);

        stringBuilder.append(100000 + integer);

        return stringBuilder.substring(1).toString();
    }

    /**
     * 使用单引号追加对象
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String appendApostrophe(T t) {
        return "'" + t + "'";
    }

    /**
     * 通过指定字符拼接字符串
     *
     * @param strings
     * @param splitFlag
     * @return
     */
    public static String appendString(String splitFlag, String... strings) {
        StringJoiner stringJoiner = new StringJoiner(splitFlag, "", "");

        for (int i = 0; i < strings.length; i++) {
            stringJoiner.add(strings[i]);
        }

        return stringJoiner.toString();
    }

    /**
     * 通过指定字符拆分字符串
     *
     * @param string
     * @param splitFlag
     * @return
     */
    public static ArrayList<String> splitString(String string, String splitFlag) {
        Iterable<String> split = Splitter.on(splitFlag).trimResults().omitEmptyStrings().split(string);
        ArrayList<String> list = new ArrayList<>();

        for (String s : split) {
            list.add(s);
        }

        return list;
    }

    /**
     * 首字母大写驼峰命名转换为下划线
     *
     * @param string
     * @return
     */
    public static String upperCamelToUnderscore(String string) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    /**
     * 首字母小写驼峰命名转换为下划线
     *
     * @param string
     * @return
     */
    public static String lowerCamelToUnderscore(String string) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, string);
    }

    /**
     * 字符串有效
     *
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * 字符串为null或有效字符为0
     *
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        return null == string || string.trim().length() == 0;
    }
}
