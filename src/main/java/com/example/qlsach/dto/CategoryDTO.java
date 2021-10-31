package com.example.qlsach.dto;

import com.example.qlsach.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    private int id;
    private String name;

    public CategoryDTO(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }
}
