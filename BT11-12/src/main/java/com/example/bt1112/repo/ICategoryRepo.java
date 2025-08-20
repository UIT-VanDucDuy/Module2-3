package com.example.bt1112.repo;

import com.example.bt1112.entity.Category;

import java.util.List;

public interface ICategoryRepo {
    List<Category> getAll();
    boolean add(Category category);
}
