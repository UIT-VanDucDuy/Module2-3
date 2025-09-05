package com.example.btthem.repo;

import com.example.btthem.dto.ProductDto;

import java.util.List;

public interface IProductRepo {
    List<ProductDto> findAll();
    List<ProductDto> findByName(String name);
    List<ProductDto> findByNameAndCategory(String searchName, String searchCategory);
}
