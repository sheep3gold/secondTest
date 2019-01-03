package com.itcast.jdbctest;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateDemo5 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from employee";
        List<Employee2> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee2.class));
        for (Employee2 employee2 : empList) {
            System.out.println(employee2);
        }
    }
}
