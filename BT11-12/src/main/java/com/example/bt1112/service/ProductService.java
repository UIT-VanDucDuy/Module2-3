package com.example.bt1112.service;

import com.example.bt1112.dto.ProductDto;
import com.example.bt1112.entity.Product;
import com.example.bt1112.repo.IProductRepo;
import com.example.bt1112.repo.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepo productRepo = new ProductRepo();
    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepo.add(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepo.delete(id);
    }

    @Override
    public List<ProductDto> findByCategory(String category) {
        return productRepo.findByCategory(category);
    }
}
