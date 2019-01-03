package com.itheima.dao;

import com.itheima.beans.Product;
import com.itheima.utils.JDBCTemplateUtils;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductDao {
//    static Scanner sc = new Scanner(System.in);
    JdbcTemplate jdbcTemplate = JDBCTemplateUtils.getJdbcTemplate();
    //查询所有数据
    public List<Product> findAllData() {
        String sql = "select * from products";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return list;
    }

    //通过ID查询数据
    public Product findDataById(int id) {
//        System.out.println("请输入要查询的id");
//        int pid = sc.nextInt();

        try {
            String sql = "select * from products where pid=?";
            Product product = null;
            product = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
            return product;
        }catch (EmptyResultDataAccessException e) {
//            e.printStackTrace();
//            System.out.println("该商品不存在!");
            return null;
        }
    }

    //插入数据
    public boolean createProduct(Product product) {
        String sql = "insert into products values(null,?,?,?)";
        int num = jdbcTemplate.update(
                sql, product.getPname(), product.getPrice(), product.getCategory());
        if (num > 0) {
            return true;
        }else {
            return false;
        }
    }

    //修改数据
    public boolean updateProduct(Product product) {
        String sql = "update products set pname=?,price=?,category=? where pid=?";
        int num = jdbcTemplate.update(sql,
                product.getPname(), product.getPrice(), product.getCategory(),
                product.getPid());
        if (num > 0) {
            return true;
        }else
            return false;

    }

    //通过id删除数据
    public boolean deleteDataById(int id) {
        String sql = "delete from products where pid=?";
        int num = jdbcTemplate.update(sql, id);
        if (num > 0) {
            return true;
        }else
            return false;
    }

    //分页查找
    public List<Product> findByPage(int index, int count) {
        String sql = "select * from products limit ?,?";
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), index, count);
        return list;
    }

    //

}
