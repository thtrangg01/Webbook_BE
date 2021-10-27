package com.example.qlsach.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Sach", catalog = "QLSach")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "MaSach")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "HinhAnh")
    private String img;

    @Column(name = "TenSach")
    private String name;

    @Column(name = "GiaBia")
    private int oldPrice;

    @Column(name = "GiaBan")
    private int newPrice;

    @Column(name = "NamXuatBan")
    private int year;

    @ManyToOne
    @JoinColumn(name = "MaTacGia")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "MaLoai")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "MaNXB")
    private Publisher publisher;
}
