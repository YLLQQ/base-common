package com.jn.persists.sql;

import com.jn.persists.model.OrderModel;

/**
 * com.jn.persists.sql.UnionSqlTest
 *
 * @author eleven
 * @date 2019/07/18
 */
public class UnionSqlTest {
    public static void main(String[] args) {
        UnionSql instance = UnionSql.getInstance();

        Select select = Select.getInstance();

        instance.append(select.SELECT(WeatherDO.class));

        From table = From.getInstance().FROM(WeatherDO.class);

        System.out.println(table);

        instance.append(table);

        Where where = Where.getInstance();

        where = where.EQ("city", "San Francisco");

        instance.append(where);

        Order city = Order.getInstance().sort(
                new OrderModel("city", OrderModel.Sort.ASC),
                new OrderModel("temp_hi", OrderModel.Sort.DESC)
        );

        instance.append(city);

        System.out.println(instance);


    }
}