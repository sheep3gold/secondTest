package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdbcTemplateDemo7 {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JdbcTemplateUtils.getJdbcTemplate();
        String sql = "select id,name from employee";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        System.out.println(maps);
        for (Map<String, Object> map : maps) {
            /*Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }*/
//            System.out.println(map);
            Set<String> strings = map.keySet();
//            System.out.println(strings);
            for (String string : strings) {
                System.out.print(map.get(string) + "   ");
            }
            System.out.println();
        }
    }
}
