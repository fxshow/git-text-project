package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface IproductService {
    public List<Product> findAll();

    void save(Product product);

    Product findById(String productId);

    void updateProduct(Product product);

    void deleteProduct(String id);
}
