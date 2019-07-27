package com.jn.persists.sql;

/**
 * com.jn.persists.sql.UnionSql
 *
 * @author eleven
 * @date 2019/07/18
 */
public class UnionSql {

    private String segment;

    private UnionSql() {
        this.segment = "";
    }

    public static UnionSql getInstance() {
        return new UnionSql();
    }

    public String append(String defineSql) {
        this.segment += defineSql;

        return this.segment;
    }

    public String append(DefineSql defineSql) {
        this.segment += defineSql;

        return this.segment;
    }

    @Override
    public String toString() {
        return segment;
    }

}
