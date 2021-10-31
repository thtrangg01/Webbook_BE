package com.example.qlsach.service;

import com.example.qlsach.entity.Book;
import com.example.qlsach.form.FormCreateBook;
import com.example.qlsach.form.FormUpdateBook;

import java.util.List;

public class BookService implements IBookService{
    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public Book getBookByName(String name) {
        return null;
    }

    @Override
    public boolean updateBook(int id, FormUpdateBook formUpdateBook) {
        return false;
    }

    @Override
    public Book createBook(FormCreateBook formCreateBook) {
        return null;
    }

    @Override
    public boolean deleteBookById(int id) {
        return false;
    }
}
