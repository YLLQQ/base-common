package com.jn.utils;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhh
 * @description 主键辅助工具类
 * @date 2019-07-13 10:20
 */
public class IdUtil {

    private static AtomicInteger START_ID = new AtomicInteger(0);

    /**
     * 10000 常量
     */
    private static final int CONVERT_COUNT_FLAG_T = 90000;

    /**
     * 获取UUID
     * <p>
     * 130d5880-bd18-4b37-a80f-feec2ee33093
     *
     * @return
     */
    public static String getFullUuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取UUID
     * <p>
     * 25f4962170694849acc6cf3fdb46df26
     *
     * @return
     */
    public static String getUuid() {
        return getFullUuid().replaceAll("-", "");
    }

    /**
     * 根据时间生成订单编号
     * 2019072315151632600007
     *
     * @return
     */
    public static String getOrderIdByTime() {

        int andIncrement = START_ID.getAndIncrement();

        if (andIncrement >= CONVERT_COUNT_FLAG_T) {
            START_ID = new AtomicInteger(0);
        }

        return DateUtil.getFullNumDateTime() + StringUtil.formatIntWithZero(andIncrement);
    }

}
