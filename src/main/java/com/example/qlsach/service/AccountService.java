package com.example.qlsach.service;

import com.example.qlsach.entity.Account;
import com.example.qlsach.form.FormUpdateAccount;
import com.example.qlsach.form.FormCreateAccount;
import com.example.qlsach.repository.IAccountRepository;
import com.example.qlsach.security.AuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> getAllAcount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public boolean login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (account.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAccount(int id, FormUpdateAccount formUpdateAccount) {
        Account account = accountRepository.getById(id);
        if (account == null){
            return false;
        }

        if (formUpdateAccount.getPassword() != null) {
            account.setPassword(formUpdateAccount.getPassword());
        }
        if (formUpdateAccount.getAddress() != null) {
            account.setAddress(formUpdateAccount.getAddress());
        }
        if (formUpdateAccount.getEmail() != null) {
            account.setEmail(formUpdateAccount.getEmail());
        }
        if (formUpdateAccount.getFullname() != null) {
            account.setFullname(formUpdateAccount.getFullname());
        }
        if (formUpdateAccount.getPhoneNumber() != null) {
            account.setPhoneNumber(formUpdateAccount.getPhoneNumber());
        }

        accountRepository.save(account);
        return true;
    }

    @Override
    public Account createAccount(FormCreateAccount formCreateAccount) {
        Account account = new Account();
        account.setFullname(formCreateAccount.getFullname());
        account.setEmail(formCreateAccount.getEmail());
        account.setPhoneNumber(formCreateAccount.getPhoneNumber());
        account.setAddress(formCreateAccount.getAddress());
        account.setUsername(formCreateAccount.getUsername());
        account.setCreateDate(LocalDateTime.now());

        PasswordEncoder encoder = new AuthenticationConfig().passwordEncoder();
        String encodedPassword = encoder.encode(formCreateAccount.getPassword());
        account.setPassword(encodedPassword);
        accountRepository.save(account);
        return accountRepository.findByUsername(account.getUsername());
    }

//    public static void main(String[] args) {
//        PasswordEncoder encoder = new AuthenticationConfig().passwordEncoder();
//        String encodedPassword = encoder.encode("thtrang");
//        System.out.println(encodedPassword);
//    }

    @Override
    public boolean deleteAccountById(int id) {
        Account account = accountRepository.getById(id);
        if (account == null){
            return false;
        }
        accountRepository.delete(account);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
    }
}
