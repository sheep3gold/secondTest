package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateDemo6 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select name from employee";
        List<String> list = jdbcTemplate.queryForList(sql, String.class);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
