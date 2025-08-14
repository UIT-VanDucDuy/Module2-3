package com.example.bt1112.repo;

import com.example.bt1112.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(int id);

}
