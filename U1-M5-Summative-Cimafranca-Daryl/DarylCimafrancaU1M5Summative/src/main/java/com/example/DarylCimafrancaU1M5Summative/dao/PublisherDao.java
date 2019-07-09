package com.example.DarylCimafrancaU1M5Summative.dao;

import com.example.DarylCimafrancaU1M5Summative.model.Publisher;

import java.util.List;

public interface PublisherDao {

    Publisher addPublisher(Publisher publisher);

    List<Publisher> getAllPublishers();

    Publisher getPublisher(int id);

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);

}
