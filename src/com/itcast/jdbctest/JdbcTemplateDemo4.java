package com.itcast.jdbctest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from employee where name=?";
        Employee2 employee2 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Employee2.class), "孙悟空");
        System.out.println(employee2);
    }
}
