package com.itheima.service;

import com.itheima.beans.Product;
import com.itheima.dao.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDao pd = new ProductDao();
    //查询所有数据
    public List<Product> findAllData() {
        return pd.findAllData();
    }

    //通过id查询数据
    public Product findDataById(int id) {
        return pd.findDataById(id);
    }

    //插入数据
    public boolean createProduct(Product product) {
        return pd.createProduct(product);
    }

    //修改数据
    public boolean updateProduct(Product product) {
        return pd.updateProduct(product);
    }

    //通过id删除数据
    public boolean deleteDataById(int id) {
        return pd.deleteDataById(id);
    }

    //批量删除
    public void deleteProductInTransaction(ArrayList<Integer> pidList) {
        for (int i = pidList.size() - 1; i >= 0; i--) {
            Integer pid = pidList.get(i);
            boolean b = pd.deleteDataById(pid);
            if (b) {
                pidList.remove(i);
            }
        }
    }


    public List<Product> findByPage(int page) {
        int count = 8;
        int index = (page - 1) * 8;
        return pd.findByPage(index, count);
    }

}
