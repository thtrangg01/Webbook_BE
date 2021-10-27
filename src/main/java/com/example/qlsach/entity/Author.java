package com.example.qlsach.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "TacGia", catalog = "QLSach")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "MaTacGia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "TenTacGia")
    private String name;

    @Column(name = "MoTa")
    private String description;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> bookList;



}
