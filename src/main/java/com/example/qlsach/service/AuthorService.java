package com.example.qlsach.service;

import com.example.qlsach.entity.Author;
import com.example.qlsach.form.FormCreateAuthor;
import com.example.qlsach.form.FormUpdateAuthor;

import java.util.List;

public class AuthorService implements IAuthorService{
    @Override
    public List<Author> getAllAuthor() {
        return null;
    }

    @Override
    public Author getAuthorById(int id) {
        return null;
    }

    @Override
    public boolean updateAuthor(int id, FormUpdateAuthor formUpdateAuthor) {
        return false;
    }

    @Override
    public Author createAuthor(FormCreateAuthor formCreateAuthor) {
        return null;
    }

    @Override
    public boolean deleteAuthorById(int id) {
        return false;
    }
}
