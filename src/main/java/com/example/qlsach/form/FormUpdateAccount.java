package com.example.qlsach.form;

import lombok.Data;

@Data
public class FormUpdateAccount {
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
}
