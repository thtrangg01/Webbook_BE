package com.example.qlsach.controller;

import com.example.qlsach.dto.BookDTO;
import com.example.qlsach.entity.Book;
import com.example.qlsach.form.FormCreateBook;
import com.example.qlsach.form.FormUpdateBook;
import com.example.qlsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public ResponseEntity getAll(){
        List<BookDTO> bookDTOList = new ArrayList<>();
        bookService.getAllBook().forEach(book -> bookDTOList.add(new BookDTO(book)));

        return new ResponseEntity(bookDTOList , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") int id){
        Book book = bookService.getBookById(id);
        if(book == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(new BookDTO(book), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") int id){
        if(bookService.deleteBookById(id)){
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") int id, @RequestBody(required = true) FormUpdateBook frm){
        if(bookService.updateBook(id, frm)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody(required = true) FormCreateBook frm){
        Book book = bookService.createBook(frm);
        if (book == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new BookDTO(book), HttpStatus.OK);
    }
}
