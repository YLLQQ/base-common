package com.jn.persists.sql;

import com.jn.utils.MainUtil;
import com.jn.utils.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.StringJoiner;

/**
 * com.jn.persists.sql.Where
 *
 * @author eleven
 * @date 2019/07/18
 */
public class Where implements DefineSql {

    private String segment;

    private Where(String segment) {
        this.segment = segment;
    }

    @Getter
    @AllArgsConstructor
    private enum Operator {
        EQ(" = "),
        NE(" != "),
        NOE(" <> "),
        LT(" < "),
        LE(" <= "),
        GT(" > "),
        GE(" >= "),
        IN(" IN "),
        NOT_IN(" NOT IN "),
        IS_NULL(" IS NULL"),
        IS_NOT_NULL(" IS NOT NULL"),
        AND(" AND "),
        OR(" OR ");

        private String operator;
    }

    /**
     * 拼接SQL
     *
     * @param operator
     * @return
     */
    private Where appendSql(Operator operator) {
        return new Where(this.segment + operator.getOperator());
    }

    /**
     * 拼接SQL
     *
     * @param column
     * @param operator
     * @return
     */
    private Where appendSql(String column, Operator operator) {
        return new Where(this.segment + column + operator.getOperator());
    }

    /**
     * 拼接SQL
     *
     * @param column
     * @param value
     * @param operator
     * @return
     */
    private Where appendSql(String column, Object value, Operator operator) {
        if (MainUtil.isNotNumber(value)) {
            value = StringUtil.appendApostrophe(value);
        }

        return new Where(this.segment + column + operator.getOperator() + value);
    }

    /**
     * 拼接SQL
     *
     * @param column
     * @param operator
     * @param values
     * @return
     */
    public Where appendSql(String column, Operator operator, Object... values) {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")");

        for (Object value : values) {
            if (MainUtil.isNotNumber(value)) {
                stringJoiner.add(StringUtil.appendApostrophe(value));
            } else {
                stringJoiner.add(value.toString());
            }
        }

        return new Where(this.segment + column + operator.getOperator() + stringJoiner.toString());
    }

    public static Where getInstance() {
        return new Where(" WHERE ");
    }

    public static Where getInstanceWithoutFlag() {
        return new Where("");
    }

    /**
     * NOT_IN
     *
     * @param column
     * @param values
     * @return
     */
    public Where NOT_IN(String column, Object... values) {
        return appendSql(column, Operator.NOT_IN, values);
    }

    /**
     * IN
     *
     * @param column
     * @param values
     * @return
     */
    public Where IN(String column, Object... values) {
        return appendSql(column, Operator.IN, values);
    }

    /**
     * LIKE
     *
     * @param column
     * @param value
     * @return
     */
    public Where LIKE(String column, Object value) {
        return new Where(this.segment + column + " like '" + value + "' ");
    }

    /**
     * 大于等于，>=
     *
     * @param column
     * @param value
     * @return
     */
    public Where GE(String column, Object value) {
        return appendSql(column, value, Operator.GE);
    }

    /**
     * 大于，>
     *
     * @param column
     * @param value
     * @return
     */
    public Where GT(String column, Object value) {
        return appendSql(column, value, Operator.GT);
    }


    /**
     * 小于等于，<=
     *
     * @param column
     * @param value
     * @return
     */
    public Where LE(String column, Object value) {
        return appendSql(column, value, Operator.LE);
    }

    /**
     * 小于，<
     *
     * @param column
     * @param value
     * @return
     */
    public Where LT(String column, Object value) {
        return appendSql(column, value, Operator.LT);
    }

    /**
     * 不等条件，<>
     *
     * @param column
     * @param value
     * @return
     */
    public Where NOE(String column, Object value) {
        return appendSql(column, value, Operator.NOE);
    }

    /**
     * 不等条件，!=
     *
     * @param column
     * @param value
     * @return
     */
    public Where NE(String column, Object value) {
        return appendSql(column, value, Operator.NE);
    }

    /**
     * 相等条件，=
     *
     * @param column
     * @param value
     * @return
     */
    public Where EQ(String column, Object value) {
        return appendSql(column, value, Operator.EQ);
    }

    /**
     * is null
     *
     * @return
     */
    public Where IS_NULL(String column) {
        return appendSql(column, Operator.IS_NULL);
    }

    /**
     * is not null
     *
     * @return
     */
    public Where IS_NOT_NULL(String column) {
        return appendSql(column, Operator.IS_NOT_NULL);
    }

    /**
     * and链接符
     *
     * @return
     */
    public Where AND() {
        return appendSql(Operator.AND);
    }

    /**
     * OR链接符
     *
     * @return
     */
    public Where OR() {
        return appendSql(Operator.OR);
    }

    @Override
    public String toString() {
        return segment;
    }
}
