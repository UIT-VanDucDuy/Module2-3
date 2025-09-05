package com.example.btthem.service;

import com.example.btthem.dto.ProductDto;
import com.example.btthem.repo.IProductRepo;
import com.example.btthem.repo.ProductRepo;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepo productRepo = new ProductRepo();
    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll();
    }
    @Override
    public List<ProductDto> searchByNameAndCategory(String searchName, String id) {
        if ("".equals(id) ||id == null) {
            return productRepo.findByName(searchName);
        }
        return productRepo.findByNameAndCategory(searchName,id);
    }
}
