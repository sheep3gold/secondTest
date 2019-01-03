package com.itcast.jdbctest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名：");
        String username = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        login(username, password);
    }

    private static void login(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user where username='" + username +
                    "'and password='" + password + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getString("nickname") +
                        ",欢迎您的访问");
            }else {
                System.out.println("登陆失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, stmt, conn);
        }
    }
}
