package com.example.qlsach.service;

import com.example.qlsach.entity.Account;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormCreateAccount;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {

    public List<Account> getAllAcount();

    public Account getAccountById(int id);
    public Account getAccountByUsername(String username);

    public boolean login(String username, String password);

    public boolean updateAccount(int id, FormUpdateAccount formUpdateAccount);

    public Account createAccount(FormCreateAccount formCreateAccount);

    public boolean deleteAccountById(int id);
}
