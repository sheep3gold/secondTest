package com.itcast.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = JDBCUtils2.getConnection();
        PreparedStatement pstmt = null;

        try {
            conn.setAutoCommit(false);
            String sql = "update account set balance=balance-? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 100);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();
            int num = 10 / 0;
            sql = "update account set balance=balance+? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 100);
            pstmt.setInt(2, 2);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }

    }
}
