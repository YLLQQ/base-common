package com.jn.persists.sql;

/**
 * com.jn.persists.sql.WhereTest
 *
 * @author eleven
 * @date 2019/07/18
 */
public class WhereTest {

    public static void main(String[] args) {
        Where where = Where.getInstance();

        Where eq = where.EQ("1", "1")
                .AND().NOE("2", 3)
                .AND().IS_NULL("3")
                .OR().IS_NOT_NULL("4")
                .AND().IN("a", 1, "2", "3", 4, 5, 6, 7)
                .OR().NOT_IN("b", 1, "2", "3", 4, 5, 6, 7);

        System.out.println(eq);

        Where where1 = Where.getInstance();

        eq = where1.NOT_IN("b", 1, "2", "3", 4, 5, 6, 7);

        System.out.println(eq);
    }
}
