package com.jn.persists.sql;

import com.jn.persists.model.BaseDO;

import java.util.Date;

/**
 * com.jn.persists.sql.SelectTest
 *
 * @author eleven
 * @date 2019/07/18
 */
public class SelectTest {
    public static void main(String[] args) {
        String select = Select.getInstance().SELECT(WeatherDO.class);

        System.out.println(select);

        String select1 = Select.getInstance().SELECT("a", "b", "c", "d");

        System.out.println(select1);
    }
}

class WeatherDO implements BaseDO {

    /**
     * null
     */
    private String city;

    /**
     * null
     */
    private Integer tempLo;

    /**
     * null
     */
    private Integer tempHi;

    /**
     * null
     */
    private Double prcp;

    /**
     * null
     */
    private Date date;

    /**
     * null
     */
    private Integer id;

}