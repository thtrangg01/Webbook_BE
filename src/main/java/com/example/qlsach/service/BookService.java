package com.example.qlsach.service;

import com.example.qlsach.entity.Book;
import com.example.qlsach.form.FormCreateBook;
import com.example.qlsach.form.FormUpdateBook;
import com.example.qlsach.repository.IAuthorRepository;
import com.example.qlsach.repository.IBookRepository;
import com.example.qlsach.repository.ICategoryRepository;
import com.example.qlsach.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IAuthorRepository authorRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private IPublisherRepository publisherRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public boolean updateBook(int id, FormUpdateBook formUpdateBook) {
        Book book = bookRepository.getById(id);
        if (book == null){
            return false;
        }

        if(formUpdateBook.getImg() != null){
            book.setImg(formUpdateBook.getImg());
        }
        if (formUpdateBook.getName() != null){
            book.setName(formUpdateBook.getName());
        }
        if (formUpdateBook.getOldPrice() >= 0){
            book.setOldPrice(formUpdateBook.getOldPrice());
        }
        if (formUpdateBook.getNewPrice() >= 0){
            book.setNewPrice(formUpdateBook.getNewPrice());
        }
        if (formUpdateBook.getYear() > 0){
            book.setYear(formUpdateBook.getYear());
        }
        if (formUpdateBook.getAuthorId() > 0){
            book.setAuthor(authorRepository.getById(formUpdateBook.getAuthorId()));
        }
        if (formUpdateBook.getCategoryId() > 0){
            book.setCategory(categoryRepository.getById(formUpdateBook.getCategoryId()));
        }
        if (formUpdateBook.getPublisherId() > 0){
            book.setPublisher(publisherRepository.getById(formUpdateBook.getPublisherId()));
        }

        bookRepository.save(book);
        return true;
    }

    @Override
    public Book createBook(FormCreateBook formCreateBook) {
        Book book = new Book();
        book.setImg(formCreateBook.getImg());
        book.setName(formCreateBook.getName());
        book.setOldPrice(formCreateBook.getOldPrice());
        book.setNewPrice(formCreateBook.getNewPrice());
        book.setYear(formCreateBook.getYear());
        book.setAuthor(authorRepository.getById(formCreateBook.getAuthorId()));
        book.setCategory(categoryRepository.getById(formCreateBook.getCategoryId()));
        book.setPublisher(publisherRepository.getById(formCreateBook.getPublisherId()));

        bookRepository.save(book);
        return bookRepository.findByName(book.getName());
    }

    @Override
    public boolean deleteBookById(int id) {
        Book book = bookRepository.getById(id);
        if (book == null){
            return false;
        }
        bookRepository.delete(book);
        return true;
    }
}
