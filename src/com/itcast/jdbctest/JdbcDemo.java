package com.itcast.jdbctest;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获得连接
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbctest", "root", "admin");
        //
        Statement statement = conn.createStatement();
        String sql = "select * from user;";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " ");
            System.out.println(rs.getString("username") + " ");
            System.out.println(rs.getString("password") + " ");
            System.out.println(rs.getString("nickname") + " ");
            System.out.println(rs.getInt("age"));
            System.out.println();
        }
        rs.close();
        statement.close();
        conn.close();
    }
}
