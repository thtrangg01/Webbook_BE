package com.example.qlsach.service;

import com.example.qlsach.entity.Publisher;
import com.example.qlsach.form.FormCreatePublisher;
import com.example.qlsach.form.FormUpdatePublisher;
import com.example.qlsach.repository.IPublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService implements IPublisherService{

    @Autowired
    private IPublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.getById(id);
    }

    @Override
    public boolean updatePublisher(int id, FormUpdatePublisher formUpdatePublisher) {
        Publisher publisher = publisherRepository.getById(id);
        if (publisher == null){
            return false;
        }

        if (formUpdatePublisher.getName() != null){
            publisher.setName(formUpdatePublisher.getName());
        }
        if (formUpdatePublisher.getAddress() != null){
            publisher.setAddress(formUpdatePublisher.getAddress());
        }

        publisherRepository.save(publisher);
        return true;
    }

    @Override
    public Publisher createPublisher(FormCreatePublisher formCreatePublisher) {
        Publisher publisher = new Publisher();
        publisher.setName(formCreatePublisher.getName());
        publisher.setAddress(formCreatePublisher.getAddress());

        publisherRepository.save(publisher);
        return publisherRepository.findByName(publisher.getName());
    }

    @Override
    public boolean deletePublisherById(int id) {
        Publisher publisher = publisherRepository.getById(id);
        if (publisher == null){
            return false;
        }
        publisherRepository.delete(publisher);
        return true;
    }
}
