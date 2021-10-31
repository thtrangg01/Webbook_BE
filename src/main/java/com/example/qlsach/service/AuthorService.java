package com.example.qlsach.service;

import com.example.qlsach.entity.Account;
import com.example.qlsach.entity.Author;
import com.example.qlsach.form.FormCreateAuthor;
import com.example.qlsach.form.FormUpdateAuthor;
import com.example.qlsach.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.getById(id);
    }

    @Override
    public boolean updateAuthor(int id, FormUpdateAuthor formUpdateAuthor) {
        Author author = authorRepository.getById(id);
        if (author == null){
            return false;
        }

        if (formUpdateAuthor.getName() != null){
            author.setName(formUpdateAuthor.getName());
        }
        if(formUpdateAuthor.getDescription() != null){
            author.setDescription(formUpdateAuthor.getDescription());
        }
        authorRepository.save(author);
        return true;
    }

    @Override
    public Author createAuthor(FormCreateAuthor formCreateAuthor) {
        Author author = new Author();
        author.setName(formCreateAuthor.getName());
        author.setDescription(formCreateAuthor.getDescription());

        authorRepository.save(author);
        return authorRepository.findByName(author.getName());
    }

    @Override
    public boolean deleteAuthorById(int id) {
        Author author = authorRepository.getById(id);
        if (author == null){
            return false;
        }
        authorRepository.delete(author);
        return true;
    }
}
