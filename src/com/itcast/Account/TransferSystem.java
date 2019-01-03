package com.itcast.Account;

public class TransferSystem {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.transfer(1, 2, 100);
    }
}
