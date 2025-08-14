package com.example.bt1112.service;

import com.example.bt1112.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
    boolean delete(int id);
}
