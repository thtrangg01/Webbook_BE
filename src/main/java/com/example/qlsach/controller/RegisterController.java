package com.example.qlsach.controller;


import com.example.qlsach.dto.AccountDTO;
import com.example.qlsach.entity.Account;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/register")
@RestController
public class RegisterController {

    @Autowired
    public IAccountService accountService;

    @PostMapping
    public ResponseEntity createAccount(@RequestBody(required = true) FormCreateAccount formCreateAccount){
        Account account = accountService.createAccount(formCreateAccount);
        if (account == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new AccountDTO(account), HttpStatus.CREATED);
    }
}
