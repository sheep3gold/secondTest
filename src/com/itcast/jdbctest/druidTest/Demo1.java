package com.itcast.jdbctest.druidTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(Demo1.class.getResourceAsStream("/druid.properties"));
        //创建连接池
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }
    }
}
