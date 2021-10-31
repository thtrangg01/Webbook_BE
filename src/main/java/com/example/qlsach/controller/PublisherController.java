package com.example.qlsach.controller;

import com.example.qlsach.dto.PublisherDTO;
import com.example.qlsach.entity.Publisher;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.form.FormCreatePublisher;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormUpdatePublisher;
import com.example.qlsach.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publisher")
@CrossOrigin("*")
public class PublisherController {
    @Autowired
    private IPublisherService publisherService;

    @GetMapping
    public ResponseEntity getAll(){
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        publisherService.getAllPublisher().forEach(publisher -> publisherDTOS.add(new PublisherDTO(publisher)));

        return new ResponseEntity(publisherDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") int id){
        Publisher publisher = publisherService.getPublisherById(id);
        if(publisher == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(new PublisherDTO(publisher), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") int id){
        if(publisherService.deletePublisherById(id)){
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") int id, @RequestBody(required = true) FormUpdatePublisher frm){
        if(publisherService.updatePublisher(id, frm)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody(required = true) FormCreatePublisher frm){
        Publisher publisher = publisherService.createPublisher(frm);
        if (publisher == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new PublisherDTO(publisher), HttpStatus.OK);
    }

}
