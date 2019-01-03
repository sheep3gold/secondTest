package com.itcast.jdbctest;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo2 {
    public static void main(String[] args) {
//        searchAll();
//        insert();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名:");
        String username = sc.nextLine();
        System.out.println("请输入您的密码：");
        String password = sc.nextLine();
        login(username, password);
    }

    public static void searchAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            JDBCUtils2.loadDriver();
            conn = JDBCUtils2.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id")
                        + " " + rs.getString("username") + " "
                        + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, stmt, conn);
        }
    }

    public static void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "insert into user (username,password) values (?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "admin");
            pstmt.setString(2, "123");
            int i = pstmt.executeUpdate();
            System.out.println("插入了" + i + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }

    }

    public static void login(String name, String passwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2, passwd);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nickname")+"登陆成功");
            }else {
                System.out.println("登陆失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
    }
}
