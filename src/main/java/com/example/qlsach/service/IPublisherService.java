package com.example.qlsach.service;

import com.example.qlsach.entity.Publisher;
import com.example.qlsach.form.FormCreatePublisher;
import com.example.qlsach.form.FormUpdatePublisher;

import java.util.List;

public interface IPublisherService {
    public List<Publisher> getAllPublisher();

    public Publisher getPublisherById (int id);

    public boolean updatePublisher(int id, FormUpdatePublisher formUpdatePublisher);

    public Publisher createPublisher(FormCreatePublisher formCreatePublisher);

    public boolean deletePublisherById(int id);
}
