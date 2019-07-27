package com.jn.utils;

/**
 * com.jn.utils.StringUtilTest
 *
 * @author eleven
 * @date 2019/07/23
 */
public class StringUtilTest {
    public static void main(String[] args) {

        long total = 0;

        for (int i = 0; i < 1000; i++) {
            long start = DateUtil.getCurrentMillis();
            StringUtil.formatIntWithZero(5);
            long end = DateUtil.getCurrentMillis();

            total += end - start;
        }

        System.out.println(total);
    }
}