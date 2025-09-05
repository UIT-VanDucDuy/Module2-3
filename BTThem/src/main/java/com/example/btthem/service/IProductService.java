package com.example.btthem.service;

import com.example.btthem.dto.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> findAll();
    List<ProductDto> searchByNameAndCategory(String name,String category);
}
