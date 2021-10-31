package com.example.qlsach.service;

import com.example.qlsach.entity.Category;
import com.example.qlsach.form.FormCreateCategory;
import com.example.qlsach.form.FormUpdateCategory;
import com.example.qlsach.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public boolean updateCategory(int id, FormUpdateCategory formUpdateCategory) {
        Category category = categoryRepository.getById(id);
        if (category == null){
            return false;
        }

        if (formUpdateCategory.getName() != null){
            category.setName(formUpdateCategory.getName());
        }

        categoryRepository.save(category);
        return true;
    }

    @Override
    public Category createCategory(FormCreateCategory formCreateCategory) {
        Category category = new Category();
        category.setName(formCreateCategory.getName());

        categoryRepository.save(category);
        return categoryRepository.findByName(category.getName());
    }

    @Override
    public boolean deleteCategoryById(int id) {
        Category category = categoryRepository.getById(id);
        if (category == null){
            return false;
        }
        categoryRepository.delete(category);
        return true;
    }
}
