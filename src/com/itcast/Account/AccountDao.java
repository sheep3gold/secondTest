package com.itcast.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

    public void outMoney(int id, double money) {
        String sql = "update account set balance=balance-? where id=?";
        updateAccount(sql, id, money);
    }

    public void inMoney(int id, double money) {
        String sql = "update account set balance=balance+? where id=?";
        updateAccount(sql, id, money);
    }

    public void updateAccount(String sql, int id, double money) {
        Connection conn = C3p0Util.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, money);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3p0Util.release(pstmt, conn);
        }
    }
}
