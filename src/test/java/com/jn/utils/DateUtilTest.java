package com.jn.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * com.jn.utils.DateUtilTest
 *
 * @author eleven
 * @date 2019/07/19
 */
class DateUtilTest {

    public static void main(String[] args) {
        System.out.println(DateUtil.getCurrentDate());
        System.out.println(DateUtil.getSimpleDateTime());
        System.out.println(DateUtil.getCurrentMillis());
        System.out.println(DateUtil.getCurrentSeconds());
        System.out.println(DateUtil.millisToDateTime(1563503448207L));
        System.out.println(DateUtil.secondsToDateTime(1563503448L));
        System.out.println(DateUtil.stringToDateTime("2019-07-19 10:45:55"));
        System.out.println(DateUtil.getNumDateTime());
        System.out.println(DateUtil.getFullNumDateTime());
        System.out.println(DateUtil.toDate(LocalDate.now()));
        System.out.println(DateUtil.toDate(LocalDateTime.now()));
    }

}