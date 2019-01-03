package com.itcast.test;

import com.itcast.jdbctest.JdbcTemplateUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo9 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select count(*) from employee";
        Integer num = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(num);
    }
}
