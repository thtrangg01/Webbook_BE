package com.example.qlsach.form;

import com.example.qlsach.entity.Author;
import com.example.qlsach.entity.Category;
import com.example.qlsach.entity.Publisher;
import lombok.Data;

@Data
public class FormCreateBook {
    private String img;
    private String name;
    private int oldPrice;
    private int newPrice;
    private int year;
    private int authorId;
    private int categoryId;
    private int publisherId;
}
