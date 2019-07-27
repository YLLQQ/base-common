package com.jn.persists.sql;

/**
 * com.jn.persists.sql.FromTest
 *
 * @author eleven
 * @date 2019/07/18
 */
public class FromTest {
    public static void main(String[] args) {
        From from = From.getInstance().FROM(WeatherDO.class);

        System.out.println(from);

        From from1 = From.getInstance().FROM("a", "b", "c");

        System.out.println(from1);
    }
}