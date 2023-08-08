package com.udyogr.redis.RedisDemo.service;

import com.udyogr.redis.RedisDemo.entity.Product;
import com.udyogr.redis.RedisDemo.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Product save(Product product) {
        return productDao.save(product);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(long id) {
        return productDao.findById(id);
    }

    public String delete(long id) {
        return productDao.delete(id);
    }
}
