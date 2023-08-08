package com.udyogr.redis.RedisDemo.repository;

import com.udyogr.redis.RedisDemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class ProductDao implements Serializable {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String HASH_KEY = "Product";

    // Put
    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    // Get All
    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    // Find
    public Product findById(long id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    // Delete
    public String delete(long id) {
        redisTemplate.opsForHash().delete(id, HASH_KEY);
        return String.format("Product %d deleted");
    }
}
