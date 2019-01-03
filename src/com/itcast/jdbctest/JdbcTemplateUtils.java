package com.itcast.jdbctest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateUtils {
    private static final ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");

    public static JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate;
    }

}
