package com.itheima.service.impl;

import com.itheima.dao.IproductDao;
import com.itheima.domain.Product;
import com.itheima.service.IproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IproductServiceImpl implements IproductService {

    @Autowired
    private IproductDao iproductDao;

    public List<Product> findAll() {
        System.out.println("service层111111");
        return iproductDao.findAll();
    }

    public void save(Product product) {
        iproductDao.save(product);
        System.out.println("2345689");
    }

    @Override
    public Product findById(String productId) {
        return iproductDao.findById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        iproductDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        iproductDao.deleteProduct(id);
    }
}
