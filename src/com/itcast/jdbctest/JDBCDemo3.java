package com.itcast.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Student student = new Student();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from student";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setDate(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
        System.out.println(student);
    }
}
