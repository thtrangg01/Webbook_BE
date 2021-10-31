package com.example.qlsach.controller;

import com.example.qlsach.dto.CategoryDTO;
import com.example.qlsach.entity.Category;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.form.FormCreateCategory;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormUpdateCategory;
import com.example.qlsach.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategoryService CategoryService;

    @GetMapping
    public ResponseEntity getAll(){
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        CategoryService.getAllCategory().forEach(category -> categoryDTOList.add(new CategoryDTO(category)));

        return new ResponseEntity(categoryDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") int id){
        Category category = CategoryService.getCategoryById(id);
        if(category == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(new CategoryDTO(category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable(name = "id") int id){
        if(CategoryService.deleteCategoryById(id)){
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable(name = "id") int id, @RequestBody(required = true) FormUpdateCategory frm){
        if(CategoryService.updateCategory(id, frm)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody(required = true) FormCreateCategory frm){
        Category category = CategoryService.createCategory(frm);
        if (category == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new CategoryDTO(category), HttpStatus.OK);
    }
}
