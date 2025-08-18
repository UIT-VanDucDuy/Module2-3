package com.example.bt1112.service;

import com.example.bt1112.entity.Category;
import com.example.bt1112.repo.CategoryRepo;
import com.example.bt1112.repo.ICategoryRepo;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public List<Category> getAll() {
        return categoryRepo.getAll() ;
    }
}
