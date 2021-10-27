package com.example.qlsach.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "NhaXuatBan", catalog = "QLSach")
public class Publisher {
    private static final long serialVersionUID = 1L;

    @Column(name = "MaNXB")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TenNXB")
    private String name;

    @Column(name = "DiaChi")
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> bookList;

}
