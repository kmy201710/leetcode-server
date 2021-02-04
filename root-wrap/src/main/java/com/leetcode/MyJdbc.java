package com.leetcode;

import java.sql.*;

/**
 * @Author hhe
 * @Date 2021/2/4 17:12
 * @Description Jdbc测试类
 */
public class MyJdbc {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/wya_leetcode";

    //  Database credentials
    private static final String USER = "root";

    private static final String PASS = "newpass";

    /**
     * 加载驱动
     */
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 处理返回结果集
     */
    public static void printResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            while (rs.next()) {
                StringBuffer b = new StringBuffer();
                b.append("-" + rs.getRow() + "-");
                for (int i = 1; i <= cols; i++) {
                    b.append(meta.getColumnName(i) + "=");
                    b.append(rs.getString(i) + "/");
                }
                System.out.println(b.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭连接
     */
    public static void close(ResultSet rs, Statement stm, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (stm != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from t_code order by id desc";
        try {
            ps = con.prepareStatement(sql);
            if (ps.execute()) {
                rs = ps.getResultSet();
                printResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }
        System.out.println("=====end=====");
    }
}
