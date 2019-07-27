package com.jn.persists.model;

import lombok.AllArgsConstructor;

/**
 * com.jn.persists.model.OrderModel
 *
 * @author eleven
 * @date 2019/07/18
 */
@AllArgsConstructor
public class OrderModel {

    private String column;

    private Sort sort;

    public enum Sort {
        DESC, ASC;
    }

    @Override
    public String toString() {
        return column + " " + sort;
    }
}
