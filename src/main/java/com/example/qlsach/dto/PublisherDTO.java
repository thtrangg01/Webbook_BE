package com.example.qlsach.dto;


import com.example.qlsach.entity.Publisher;
import lombok.Data;

@Data
public class PublisherDTO {
    private int id;
    private String name;
    private String address;

    public PublisherDTO(Publisher publisher){
        this.id = publisher.getId();
        this.name = publisher.getName();
        this.address = publisher.getAddress();
    };
}
