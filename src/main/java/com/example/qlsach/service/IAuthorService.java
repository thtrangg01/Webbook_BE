package com.example.qlsach.service;

import com.example.qlsach.entity.Author;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.form.FormCreateAuthor;
import com.example.qlsach.form.FormUpdateAuthor;

import java.util.List;

public interface IAuthorService {
    public List<Author> getAllAuthor();

    public Author getAuthorById (int id);

    public boolean updateAuthor(int id, FormUpdateAuthor formUpdateAuthor);

    public Author createAuthor(FormCreateAuthor formCreateAuthor);

    public boolean deleteAuthorById(int id);

}
