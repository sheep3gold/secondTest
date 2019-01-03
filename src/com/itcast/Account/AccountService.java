package com.itcast.Account;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {
    public void transfer(int from, int to, double money) {
        AccountDao accountDao = new AccountDao();
        Connection conn = C3p0Util.getConnection();

        try {
            conn.setAutoCommit(false);
            accountDao.outMoney(from, money);
            System.out.println(100 / 0);
            accountDao.inMoney(to, money);
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            C3p0Util.release(null, conn);
        }
    }
}
