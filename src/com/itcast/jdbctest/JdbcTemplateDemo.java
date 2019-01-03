package com.itcast.jdbctest;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils3.getDataSource());

    public static void main(String[] args) {
        //2. 编写建表的SQL语句
        //准备sql语句
        //1)id是主键，整数类型，自增长
        //2)name是varchar(20)，非空
        //3)性别是boolean类型
        //4)生日是date类型
        /*String sql = "create table employee(" +
                "id int primary key auto_increment," +
                "name varchar(20) not null," +
                "gender varchar(2)," +
                "birthday date)";
        jdbcTemplate.execute(sql);*/
        insert();
//        update();
//        delete();
    }

    private static void insert() {
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "孙悟空", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "孙悟天", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "孙悟饭", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "龟仙人", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "牛魔王", "男", "1999-12-10");
        jdbcTemplate.update("insert into employee values (" +
                "null ,?,?,?)", "18号", "男", "1999-12-10");
    }

    public static void update() {
        int row = jdbcTemplate.update("update employee set name=?," +
                "birthday=? where id=?", "苦林", "1994-12-10", 2);
        System.out.println("更新了" + row + "条记录");
    }

    public static void delete() {
        int row = jdbcTemplate.update("delete from  employee where id=?", 6);
        System.out.println("删除了" + row + "行记录");
    }
}
