package com.jn.persists.sql;

import com.jn.persists.model.BaseDO;
import com.jn.utils.ClassUtil;
import com.jn.utils.StringUtil;

/**
 * com.jn.persists.sql.From
 *
 * @author eleven
 * @date 2019/07/18
 */
public class From implements DefineSql {

    private String segment;

    private From(String segment) {
        this.segment = segment;
    }

    private From appendSql(String sql) {
        return new From(this.segment + sql);
    }

    public static From getInstance() {
        return new From(" FROM ");
    }

    public static From getInstanceWithoutFlag() {
        return new From("");
    }

    public From AND(String condition) {
        return appendSql(" AND " + condition);
    }

    public From ON(String condition) {
        return appendSql(" ON " + condition);
    }

    public From INNER_JOIN(String tableName) {
        return appendSql(" INNER JOIN " + tableName);
    }

    public From RIGHT_JOIN(String tableName) {
        return appendSql(" RIGHT JOIN " + tableName);
    }

    public From LEFT_JOIN(String tableName) {
        return appendSql(" LEFT JOIN " + tableName);
    }

    public From FROM(String... tableNames) {
        String tables = StringUtil.appendString(",", tableNames);

        return appendSql(tables);
    }

    public <T extends BaseDO> From FROM(Class<T> tClass) {
        String fullColumn = ClassUtil.getTableNameByDOClass(tClass);

        return appendSql(fullColumn);
    }

    @Override
    public String toString() {
        return segment;
    }
}
