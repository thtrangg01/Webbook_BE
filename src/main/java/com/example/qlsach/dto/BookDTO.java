package com.example.qlsach.dto;

import com.example.qlsach.entity.Book;
import lombok.Data;

@Data
public class BookDTO {
    private int id;
    private String img;
    private String name;
    private int oldPrice;
    private int newPrice;
    private int year;
    private String author;
    private String category;
    private String publisher;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.img = book.getImg();
        this.name = book.getName();
        this.oldPrice = book.getOldPrice();
        this.newPrice = book.getNewPrice();
        this.year = book.getYear();
        this.author = book.getAuthor().getName();
        this.category = book.getCategory().getName();
        this.publisher = book.getPublisher().getName();
    }
}
