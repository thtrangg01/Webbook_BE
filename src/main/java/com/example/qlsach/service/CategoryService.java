package com.example.qlsach.service;

import com.example.qlsach.entity.Category;
import com.example.qlsach.form.FormCreateCategory;
import com.example.qlsach.form.FormUpdateCategory;

import java.util.List;

public class CategoryService implements ICategoryService{
    @Override
    public List<Category> getAllCategory() {
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public boolean updateCategory(int id, FormUpdateCategory formUpdateCategory) {
        return false;
    }

    @Override
    public Category createCategory(FormCreateCategory formCreateCategory) {
        return null;
    }

    @Override
    public boolean deleteCategoryById(int id) {
        return false;
    }
}
