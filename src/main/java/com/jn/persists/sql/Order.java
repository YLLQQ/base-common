package com.jn.persists.sql;

import com.jn.persists.model.OrderModel;

import java.util.StringJoiner;

/**
 * com.jn.persists.sql.Order
 *
 * @author eleven
 * @date 2019/07/18
 */
public class Order implements DefineSql {

    private String segment;

    private Order(String segment) {
        this.segment = segment;
    }

    public Order sort(OrderModel orderModel) {
        return new Order(this.segment + orderModel);
    }

    public Order sort(OrderModel... orderModel) {
        StringJoiner stringJoiner = new StringJoiner(",", "", "");

        for (OrderModel model : orderModel) {
            stringJoiner.add(model.toString());
        }

        return new Order(this.segment + stringJoiner);
    }

    public static Order getInstance() {
        return new Order(" ORDER BY ");
    }

    public static Order getInstanceWithoutFlag() {
        return new Order("");
    }

    @Override
    public String toString() {
        return segment;
    }
}
