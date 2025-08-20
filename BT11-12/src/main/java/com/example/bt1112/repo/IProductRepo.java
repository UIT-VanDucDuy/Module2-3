package com.example.bt1112.repo;

import com.example.bt1112.dto.ProductDto;
import com.example.bt1112.entity.Product;

import java.util.List;

public interface IProductRepo {
    List<ProductDto> findAll();
    boolean add(Product product);
    boolean delete(int id);
    List<ProductDto> findByCategory(String category);
}
