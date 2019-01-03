package com.itcast.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDemo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String username = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        login(username, password);
    }

    private static void login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nickname")
                        + ",欢迎您的访问");
            }else {
                System.out.println("登陆失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
    }
}
