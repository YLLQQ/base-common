package com.jn.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * com.jn.utils.DateUtil
 *
 * @author eleven
 * @date 2019/07/19
 */
public class DateUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER_SIMPLE = DateTimeFormatter.ofPattern(
            "yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_NUM = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_FULL_NUM = DateTimeFormatter.ofPattern(
            "yyyyMMddHHmmssSSS");
    private static final ZoneId LOCAL_ZONE_ID = ZoneId.of("Asia/Shanghai");
    private static final ZoneOffset LOCAL_ZONE = ZoneOffset.of("+8");

    /**
     * 转换为date
     * Fri Jul 19 00:00:00 CST 2019
     *
     * @param localDate
     * @return
     */
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(LOCAL_ZONE_ID).toInstant());
    }

    /**
     * 转换为date
     * Fri Jul 19 10:55:32 CST 2019
     *
     * @param localDateTime
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(LOCAL_ZONE));
    }

    /**
     * 字符串转换为时间
     *
     * @param time
     * @return
     */
    public static LocalDateTime stringToDateTime(String time) {
        return LocalDateTime.parse(time, DATE_TIME_FORMATTER_SIMPLE);
    }

    /**
     * 秒转换为时间
     * 2019-07-19T10:30:48
     *
     * @param second
     * @return
     */
    public static LocalDateTime secondsToDateTime(long second) {
        Instant instant = Instant.ofEpochSecond(second);

        return LocalDateTime.ofInstant(instant, LOCAL_ZONE_ID);
    }

    /**
     * 毫秒转换为时间
     * 2019-07-19T10:30:48.207
     *
     * @param milli
     * @return
     */
    public static LocalDateTime millisToDateTime(long milli) {
        Instant instant = Instant.ofEpochMilli(milli);

        return LocalDateTime.ofInstant(instant, LOCAL_ZONE_ID);
    }

    /**
     * 获取当前时间
     * 1563503391765
     *
     * @return
     */
    public static long getCurrentMillis() {
        return LocalDateTime.now(LOCAL_ZONE_ID).toInstant(LOCAL_ZONE).toEpochMilli();
    }

    /**
     * 获取当前时间
     * 1563503391
     *
     * @return
     */
    public static long getCurrentSeconds() {
        return LocalDateTime.now(LOCAL_ZONE_ID).toInstant(LOCAL_ZONE).getEpochSecond();
    }

    /**
     * 获取当前时间
     * 20190723095317385
     *
     * @return
     */
    public static String getFullNumDateTime() {
        return formatDateTime(DATE_TIME_FORMATTER_FULL_NUM);
    }

    /**
     * 获取当前时间
     * 190723095058767
     *
     * @return
     */
    public static String getNumDateTime() {
        return formatDateTime(DATE_TIME_FORMATTER_NUM);
    }

    /**
     * 获取当前时间
     * 2019-07-19 10:13:37
     *
     * @return
     */
    public static String getSimpleDateTime() {
        return formatDateTime(DATE_TIME_FORMATTER_SIMPLE);
    }

    /**
     * 获取当前时间
     * 2019-07-19
     *
     * @return
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now(LOCAL_ZONE_ID);
    }

    /**
     * 根据样式格式化时间戳
     *
     * @param format
     * @return
     */
    private static String formatDateTime(DateTimeFormatter format) {
        return LocalDateTime.now(LOCAL_ZONE_ID).format(format);
    }
}
