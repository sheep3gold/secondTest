package com.itcast.jdbctest;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo4 {
    public static void main(String[] args) {
        searchAll();
//        insert();
//        update();
//        delete();
    }

    public static void searchAll() {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setDate(rs.getDate("birthday"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
//        System.out.println(list);

        for (Student student : list) {
            System.out.println(student);
        }
    }

    /**
     * 插入数据
     */
    public static void insert() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "insert into student values (null,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "黑熊精");
            pstmt.setInt(2, 18);
            pstmt.setString(3, "男");
            pstmt.setDate(4, Date.valueOf("1999-03-12"));
            int num=pstmt.executeUpdate();
            System.out.println("插入了" + num + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }
    }

    /**
     * 更新数据
     */
    public static void update() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "update student set name=?,birthday=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "白龙马");
            pstmt.setDate(2, Date.valueOf("2000-03-12"));
            pstmt.setInt(3, 5);
            int i = pstmt.executeUpdate();
            System.out.println("修改了" + i + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }
    }

    public static void delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "delete from student where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            int i = pstmt.executeUpdate();
            System.out.println("删除了" + i + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }
    }

}
