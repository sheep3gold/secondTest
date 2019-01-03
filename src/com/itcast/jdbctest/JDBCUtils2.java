package com.itcast.jdbctest;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils2 {
    private static final String DRIVER_CLASSNAME;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static{
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER_CLASSNAME = properties.getProperty("driverClassName");
        URL = properties.getProperty("url");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        loadDriver();
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
    public static void release(Statement stmt, Connection conn) {
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
