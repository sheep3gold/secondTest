package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateUtils {
//    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        return jdbcTemplate;
    }
}
