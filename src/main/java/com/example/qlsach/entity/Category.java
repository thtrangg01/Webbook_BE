package com.example.qlsach.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TheLoai", catalog = "QLSach")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "MaLoai")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TenLoai")
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Book> bookList;
}
