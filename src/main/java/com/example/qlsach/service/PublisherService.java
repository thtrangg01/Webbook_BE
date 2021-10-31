package com.example.qlsach.service;

import com.example.qlsach.entity.Publisher;
import com.example.qlsach.form.FormCreatePublisher;
import com.example.qlsach.form.FormUpdatePublisher;

import java.util.List;

public class PublisherService implements IPublisherService{
    @Override
    public List<Publisher> getAllPublisher() {
        return null;
    }

    @Override
    public Publisher getPublisherById(int id) {
        return null;
    }

    @Override
    public boolean updatePublisher(int id, FormUpdatePublisher formUpdatePublisher) {
        return false;
    }

    @Override
    public Publisher createPublisher(FormCreatePublisher formCreatePublisher) {
        return null;
    }

    @Override
    public boolean deletePublisherById(int id) {
        return false;
    }
}
