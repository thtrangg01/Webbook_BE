package com.example.qlsach.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "TaiKhoan", catalog = "QLSach") // mapping
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "MaNguoiDung")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TenNguoiDung", length = 100)
    private String fullname;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "NgayDangKy")
    private LocalDateTime createDate;

    @Column(name = "SDT", unique = true, length = 20)
    private String phoneNumber;

    @Column(name = "DiaChi")
    private String address;

    @Column(name = "TenDangNhap", unique = true)
    private String username;

    @Column(name = "MatKhau")
    private String password;

    @Column(name = "IsAdmin")
    private boolean isAdmin;
}
