package com.udyogr.redis.RedisDemo.controller;

import com.udyogr.redis.RedisDemo.entity.Product;
import com.udyogr.redis.RedisDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    @Transactional
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/product")
    public Product findProduct(@RequestParam long id) {
        return productService.findById(id);
    }

    @GetMapping("/productAll")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(long id) {
        return productService.delete(id);
    }

}
