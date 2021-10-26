package com.example.qlsach.controller;

import com.example.qlsach.dto.AccountDTO;
import com.example.qlsach.entity.Account;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.service.AccountService;
import com.example.qlsach.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    public IAccountService accountService;

    @GetMapping
    public ResponseEntity getAllAccount(){
        List<Account> accounts = new ArrayList<>();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        accounts = accountService.getAllAcount();
        if (accounts.size() == 0){
            return new ResponseEntity("no account", HttpStatus.NOT_FOUND);
        }
        accounts.forEach(account -> accountDTOS.add(new AccountDTO(account)));
       return new ResponseEntity(accountDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAccountById(@PathVariable(name = "id") int id){
        Account account = accountService.getAccountById(id);
        if (account == null){
            return new ResponseEntity("no account", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new AccountDTO(account), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccountById(@PathVariable(name = "id") int id){
        if (id == 1){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (accountService.deleteAccountById(id)){
            return new ResponseEntity(HttpStatus.GONE);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAccount(@PathVariable(name = "id") int id, @RequestBody(required = true) FormUpdateAccount formUpdateAccount){
        if (accountService.updateAccount(id, formUpdateAccount)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody(required = true) FormCreateAccount formCreateAccount){
        Account account = accountService.createAccount(formCreateAccount);
        if (account == null){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new AccountDTO(account), HttpStatus.CREATED);
    }


}
