package com.jn.persists.sql;

import com.jn.persists.model.BaseDO;
import com.jn.utils.ClassUtil;
import com.jn.utils.StringUtil;

/**
 * com.jn.persists.sql.Select
 *
 * @author eleven
 * @date 2019/07/18
 */
public class Select implements DefineSql{

    private String segment;

    private Select(String segment) {
        this.segment = segment;
    }

    private String appendSql(String sql) {
        return this.segment += sql;
    }

    public static Select getInstance() {
        return new Select("SELECT ");
    }

    public static Select getInstanceWithoutFlag() {
        return new Select("");
    }

    public String SELECT(String... columns) {
        String column = StringUtil.appendString(",", columns);

        return appendSql(column);
    }

    public <T extends BaseDO> String SELECT(Class<T> tClass) {
        String fullColumn = ClassUtil.getFullColumnStringByDOClass(tClass);

        return appendSql(fullColumn);
    }

    @Override
    public String toString() {
        return segment;
    }
}
