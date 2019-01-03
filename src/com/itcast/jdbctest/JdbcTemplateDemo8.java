package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo8 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}
