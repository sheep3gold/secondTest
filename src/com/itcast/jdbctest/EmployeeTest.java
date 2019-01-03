package com.itcast.jdbctest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
//        insert("aaa", "男", Date.valueOf("1990-09-09"), 2000);
//        insert("bbb", "男", Date.valueOf("2001-09-09"), 1209);
//        insert("ccc", "女", Date.valueOf("1990-01-01"), 2100);
//        update(3);
       /* List<Employee> list = new ArrayList<>();
        list = searchAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }
        double sum = 0;
        for (Employee employee : list) {
            double d = employee.getSalary();
            sum += d;
        }
        System.out.println("所有员工的平均工资为："+sum/list.size());
        search();*/
       /* Employee e = search(1);
        System.out.println(e);*/
//        System.out.println("删除了" + delete(1) + "条数据");
//        average();
        search();
    }

    public static void insert( String name, String gender, Date joindate,double salary) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "insert into employee values(null ,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
//            pstmt.setObject(1, null);
            pstmt.setString(1, name);
            pstmt.setString(2, gender);
            pstmt.setDate(3, joindate);
            pstmt.setDouble(4, salary);
            int i = pstmt.executeUpdate();
            System.out.println("插入了" + i + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt, conn);
        }
    }

    public static void update(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "update employee set name=?,salary=?,joindate=? where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "猪八戒");
            pstmt.setInt(2, 5300);
            pstmt.setDate(3, Date.valueOf("2017-02-01"));
            pstmt.setInt(4,id);
            int i = pstmt.executeUpdate();
            System.out.println("更新了" + i + "条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(pstmt,conn);
        }
    }

    public static List<Employee> searchAll() {
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from employee";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setJoindate(rs.getDate("joindate"));
                employee.setSalary(rs.getDouble("salary"));
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
        return list;
    }

    public static void search() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from employee where name like '张%'";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setJoindate(rs.getDate("joindate"));
                employee.setSalary(rs.getDouble("salary"));
                list.add(employee);
//                System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static Employee search(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee=null;
        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select * from employee where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setGender(rs.getString("gender"));
                employee.setJoindate(rs.getDate("joindate"));
                employee.setSalary(rs.getDouble("salary"));
//                System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static int delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int i = 0;
        try {
            conn = JDBCUtils2.getConnection();
            String sql = "delete from employee where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void average() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils2.getConnection();
            String sql = "select avg(salary) as avgSalary from employee";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                double d = rs.getDouble("avgSalary");
                System.out.println(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils2.release(rs, pstmt, conn);
        }
    }
}
