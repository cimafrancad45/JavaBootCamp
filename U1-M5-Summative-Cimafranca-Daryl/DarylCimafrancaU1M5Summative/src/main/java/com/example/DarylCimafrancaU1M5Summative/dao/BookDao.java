package com.example.DarylCimafrancaU1M5Summative.dao;

import com.example.DarylCimafrancaU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> getBookByAuthor(int authorId);

}
