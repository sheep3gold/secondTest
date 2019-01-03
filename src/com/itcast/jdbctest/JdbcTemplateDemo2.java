package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from employee where id=?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 2);
        System.out.println(map);
    }
}
