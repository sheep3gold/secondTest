package com.itcast.jdbctest;

import java.sql.*;

public class JDBCUtils {
    private static final String DRIVER_CLASSNAME;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    static {
        DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";
        URL = "jdbc:mysql:///jdbctest";
        USERNAME = "root";
        PASSWORD = "admin";
    }

    /**
     * @param
     * @methodReturn
     * @desc 注册驱动的方法
     **/
    public static void loadDriver() {
        try {
            Class.forName(DRIVER_CLASSNAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接的方法
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        loadDriver();
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源的方法
     * @param stmt
     * @param conn
     */
    public static void release(Statement stmt,Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        release(stmt,connection);
    }
}
