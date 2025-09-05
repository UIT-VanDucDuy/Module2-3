package com.example.btthem.service;
import com.example.btthem.entity.Category;
import com.example.btthem.repo.CategoryRepo;
import com.example.btthem.repo.ICategoryRepo;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public List<Category> getAll() {
        return categoryRepo.getAll() ;
    }
}
