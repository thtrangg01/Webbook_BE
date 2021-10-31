package com.example.qlsach.dto;

import com.example.qlsach.entity.Author;
import lombok.Data;

@Data
public class AuthorDTO {
    private int id;
    private String name;
    private String description;

    public AuthorDTO(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.description = author.getDescription();
    };

}
