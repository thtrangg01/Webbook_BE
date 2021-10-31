package com.example.qlsach.repository;

import com.example.qlsach.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByName(String name);
}
