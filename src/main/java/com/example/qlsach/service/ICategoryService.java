package com.example.qlsach.service;


import com.example.qlsach.entity.Category;
import com.example.qlsach.form.FormCreateCategory;
import com.example.qlsach.form.FormUpdateCategory;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAllCategory();

    public Category getCategoryById (int id);

    public boolean updateCategory(int id, FormUpdateCategory formUpdateCategory);

    public Category createCategory(FormCreateCategory formCreateCategory);

    public boolean deleteCategoryById(int id);
}
