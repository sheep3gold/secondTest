package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select * from employee";
        RowMapper<List<Employee2>> e2=new RowMapper<List<Employee2>>() {

            @Override
            public List<Employee2> mapRow(ResultSet resultSet, int i) throws SQLException {
                List<Employee2> list = new ArrayList<>();
                while (resultSet.next()) {
                    Employee2 emp1 = new Employee2();
                    emp1.setId(resultSet.getInt("id"));
                    emp1.setName(resultSet.getString("name"));
                    emp1.setGender(resultSet.getString("gender"));
                    emp1.setBirthday(resultSet.getDate("birthday"));
//                    System.out.println(i);
                    list.add(emp1);
                }
                System.out.println(i);

                return list;
            }
        };
        /*Employee2 employee2 = jdbcTemplate.queryForObject(sql, e2, 2);
        Employee2 employee21 = jdbcTemplate.queryForObject(sql, e2, 1);
        System.out.println(employee21);
        System.out.println(employee2);*/
        List<Employee2> list = jdbcTemplate.queryForObject(sql, e2);
        for (Employee2 employee2 : list) {
            System.out.println(employee2);
        }
    }
}
