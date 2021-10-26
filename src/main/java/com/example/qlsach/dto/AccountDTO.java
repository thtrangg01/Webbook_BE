package com.example.qlsach.dto;

import com.example.qlsach.entity.Account;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AccountDTO {

    private int id;

    private String fullname;

    private String email;

    private LocalDateTime createDate;

    private String phoneNumber;

    private String address;

    private String username;

    private boolean isAdmin;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.fullname = account.getFullname();
        this.email = account.getEmail();
        this.createDate = account.getCreateDate();
        this.phoneNumber = account.getPhoneNumber();
        this.address = account.getAddress();
        this.username = account.getUsername();
        this.isAdmin = account.isAdmin();
    }
}
