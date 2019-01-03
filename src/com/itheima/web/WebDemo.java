package com.itheima.web;

import com.itheima.beans.Product;
import com.itheima.service.ProductService;
import sun.jvm.hotspot.debugger.posix.elf.ELFException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebDemo {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("p:分页查询\tc:创建\tu:修改\td:删除\tda:批量删除\ti:通过id查询\tfa:查询所有\tq:退出\t");
            String choice = sc.next();
            switch (choice) {
                case "p":
                    System.out.println("分页查询");
                    pageingQuery();
                    break;
                case "c":
                    System.out.println("创建");
                    createProduct();
                    break;
                case "u":
                    System.out.println("修改");
                    modifyProduct();
                    break;
                case "d":
                    System.out.println("删除");
                    System.out.println("请输入要删除的数据id");
                    int id = sc.nextInt();
                    deleteDataById(id);
                    break;
                case "da":
                    System.out.println("批量删除");
                    deleteInBaches();
                    break;
                case "i":
                    System.out.println("通过id查询");
                    System.out.println("请输入要查询的id");
                    int id1 = sc.nextInt();
                    findDataById(id1);
                    break;
                case "fa":
                    System.out.println("查询所有");
                    findAllData();
                    break;
                case "q":
                    System.out.println("退出");
                    return;
                default:
                    System.out.println("输入有误，请重新输入！！！");
                    break;
            }
        }
    }

//    static ProductService  ps = new ProductService();
    //查询所有数据
    public static void findAllData() {
        ProductService ps = new ProductService();
        List<Product> list = ps.findAllData();
        for (Product product : list) {
            System.out.println(product);
        }
    }

    //通过id查询数据
    public static void findDataById(int id) {
        ProductService ps = new ProductService();
        Product product = ps.findDataById(id);
        System.out.println(product);
    }

    //插入数据
    public static void createProduct() {
        ProductService ps = new ProductService();
        System.out.println("请输入商品名称：");
        String pname = sc.next();
        System.out.println("请输入商品的价格");
        int price = sc.nextInt();
        System.out.println("请输入商品的分类");
        String category = sc.next();

        //将商品信息封装成对象
        Product product = new Product();
        product.setPname(pname);
        product.setPrice(price);
        product.setCategory(category);
        boolean b = ps.createProduct(product);
        if (b) {
            System.out.println("数据插入成功");
        }else {
            System.out.println("数据插入失败");
        }
    }

    //修改数据
    public static void modifyProduct() {
        System.out.println("请输入需要修改的商品编号 : ");
        int pid = sc.nextInt();

        //查询id是否存在
        ProductService ps = new ProductService();
        Product product = ps.findDataById(pid);
        if (null == product) {
            System.out.println("该编号不存在!");
            return;
        }
        System.out.println("商品信息为: " + product);

        System.out.println("请输入修改后商品的名称 : ");
        String pname = sc.next();
        System.out.println("请输入修改后商品的价格 : ");
        String price_str = sc.next();
        int price = Integer.parseInt(price_str);
        System.out.println("请输入修改后商品的分类 : ");
        String category = sc.next();

        Product product1 = new Product();
        product1.setPid(pid);
        product1.setPname(pname);
        product1.setPrice(price);
        product1.setCategory(category);

        boolean b = ps.updateProduct(product1);
        if (b) {
            System.out.println("商品更新成功！");
        }else
            System.out.println("商品更新失败！");
    }

    //通过id删除数据
    public static void deleteDataById(int id) {
        ProductService ps = new ProductService();
        boolean b = ps.deleteDataById(id);
        if (b) {
            System.out.println("删除成功!");
        }else
            System.out.println("删除失败！");
    }

    //批量删除
    public static void deleteInBaches() {
        ProductService ps = new ProductService();
        System.out.println("进入批量删除模式,请输入要删除商品的编号, -1 表示退出 :");
        ArrayList<Integer> pidList = new ArrayList<>();
        while (true) {
            int pid = sc.nextInt();
            if (pid == -1) {
                break;
            }
            Product product = ps.findDataById(pid);
            if (null == product) {
                System.out.println("该编号的商品不存在, 请继续输入, -1 表示退出 :");
                continue;
            }else {
                System.out.println("商品信息:" + product);
            }
            pidList.add(pid);
        }
        System.out.println("请确认要删除共" + pidList.size() + " 件商品吗 ? y (确认) / n (取消) :");
        String choice = sc.next();
        if ("y".equalsIgnoreCase(choice)) {
            ps.deleteProductInTransaction(pidList);
            if (pidList.isEmpty()) {
                System.out.println("商品删除成功!");
            }else {
                for (Integer integer : pidList) {
                    System.out.println(integer + "号商品删除失败!");
                }
            }
        }else {
            System.out.println("操作已取消.");
        }
    }

    //分页查询
    private static void pageingQuery() {
        //1.提示用户需要查询的页码
        System.out.println("请输入需要查询商品的页码:");
        int page = sc.nextInt();
        ProductService ps = new ProductService();
        List<Product> list = ps.findByPage(page);
        if (list.isEmpty()) {
            System.out.println("该页码没有对应的商品信息.");
        }else {
            for (Product product : list) {
                System.out.println(product);
            }
        }

    }


}
