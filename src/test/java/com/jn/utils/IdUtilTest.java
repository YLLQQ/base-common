package com.jn.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * com.jn.utils.IdUtilTest
 *
 * @author eleven
 * @date 2019/07/23
 */
public class IdUtilTest {
    private static Set<String> sets = new HashSet<>(100000);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                String orderIdByTime = IdUtil.getOrderIdByTime();
                System.out.println(orderIdByTime);

                if (sets.contains(orderIdByTime)) {
                    continue;
                }
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                String orderIdByTime = IdUtil.getOrderIdByTime();
                System.out.println(orderIdByTime);

                if (sets.contains(orderIdByTime)) {
                    continue;
                }
            }
        });

        executorService.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                String orderIdByTime = IdUtil.getOrderIdByTime();
                System.out.println(orderIdByTime);

                if (sets.contains(orderIdByTime)) {
                    continue;
                }

                sets.add(orderIdByTime);
            }
        });

        executorService.shutdown();

        System.out.println("finish");
    }
}