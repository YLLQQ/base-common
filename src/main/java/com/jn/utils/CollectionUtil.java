package com.jn.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * com.jn.utils.CollectionUtil
 *
 * @author eleven
 * @date 2019/07/23
 */
public class CollectionUtil {

    /**
     * 集合为空判断
     * @param col
     * @return
     */
    public static boolean isEmpty(Collection col) {
        return col == null || col.isEmpty();
    }

    /**
     * 集合非空判断
     * @param col
     * @return
     */
    public static boolean isNotEmpty(Collection col) {
        return !isEmpty(col);
    }

    /**
     * 获取列表最后一个元素
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T getLast(List<T> list) {
        return isEmpty(list) ? null : list.get(list.size() - 1);
    }

    /**
     * map为空判断
     * @param map
     * @return
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * map非空判断
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }
}
