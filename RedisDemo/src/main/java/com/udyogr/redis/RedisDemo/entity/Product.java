package com.udyogr.redis.RedisDemo.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;

@Data
@RedisHash("Product")
public class Product implements Serializable {

    @Id
    long id;
    String name;

    Double price;

    int quantity;

}
