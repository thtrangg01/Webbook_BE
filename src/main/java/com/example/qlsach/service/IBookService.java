package com.example.qlsach.service;

import com.example.qlsach.entity.Account;
import com.example.qlsach.entity.Book;
import com.example.qlsach.form.FormCreateBook;
import com.example.qlsach.form.FormUpdateBook;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBook();

    public Book getBookById (int id);
    public Book getBookByName(String name);

    public boolean updateBook(int id, FormUpdateBook formUpdateBook);

    public Book createBook(FormCreateBook formCreateBook);

    public boolean deleteBookById(int id);
}
