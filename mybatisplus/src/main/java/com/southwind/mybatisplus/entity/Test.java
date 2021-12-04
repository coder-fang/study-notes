package com.southwind.mybatisplus.entity;

/**
 * Create By  on 2021/4/20.
 */
public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("手机");
        product.setPrice(3000.0);
        User user = new User();
        user.setTitle("name");
//        user.setProduct(product);
        /*
        user------>前端   productName
        * */
    }
}
