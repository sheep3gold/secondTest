package com.itcast.jdbctest;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Democ3p0 {
    public static void main(String[] args) {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///jdbctest");
            cpds.setUser("root");
            cpds.setPassword("admin");
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(10);
            cpds.setCheckoutTimeout(2000);
            for (int i = 1; i <= 10; i++) {
                Connection conn = cpds.getConnection();
                System.out.println("第" + i + "个连接对象:" + conn);
                if (i == 5) {
                    conn.close();
                }
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
