package com.itcast.jdbctest.druidTest;

import org.springframework.jdbc.core.JdbcTemplate;

public class Test02_04 {
    public static void main(String[] args) {
        test02();
    }

    public static void test02() {
        JdbcTemplate jdbcTemplate = DruidUtils.getJdbcTemplate();
        String sql = "select count(*) from user";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(num);
    }
}
