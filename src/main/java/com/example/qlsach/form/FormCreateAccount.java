package com.example.qlsach.form;

import lombok.Data;

@Data
public class FormCreateAccount {
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
}
