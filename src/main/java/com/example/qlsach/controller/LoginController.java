package com.example.qlsach.controller;

import com.example.qlsach.dto.AccountDTO;
import com.example.qlsach.entity.Account;
import com.example.qlsach.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/login")
@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity login(Principal principal){
       String username = principal.getName();
       Account account = accountService.getAccountByUsername(username);
        return new ResponseEntity(new AccountDTO(account), HttpStatus.OK);
    }
}
