package com.example.qlsach.controller;

import com.example.qlsach.dto.AuthorDTO;
import com.example.qlsach.entity.Author;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.form.FormCreateAuthor;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormUpdateAuthor;
import com.example.qlsach.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
@CrossOrigin("*")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public ResponseEntity getAll(){
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        authorService.getAllAuthor().forEach(author -> authorDTOS.add(new AuthorDTO(author)));
        return new ResponseEntity(authorDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") int id){
        Author author = authorService.getAuthorById(id);
        if(author == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(new AuthorDTO(author), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") int id){
        if(authorService.deleteAuthorById(id)){
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") int id, @RequestBody(required = true) FormUpdateAuthor frm){
        if(authorService.updateAuthor(id, frm)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody(required = true) FormCreateAuthor frm){
        Author author = authorService.createAuthor(frm);
        if (author == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new AuthorDTO(author), HttpStatus.OK);
    }
}
