package com.example.qlsach.repository;

import com.example.qlsach.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {
    public Author findByName(String name);
    
}
