package com.itcast.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Democ3p0_3 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtils3.getConnection();
        String sql = "insert into user values(null,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "eee");
        pstmt.setString(2, "cbd");
        pstmt.setString(3, "杨幂");
        pstmt.setInt(4, 29);

        int i = pstmt.executeUpdate();
        if (i > 0) {
            System.out.println("插入成功");
        }
        JDBCUtils3.release(pstmt,conn);
    }
}
