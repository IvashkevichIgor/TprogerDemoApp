package ru.ivashkevich.tproger_demo.service;

import ru.ivashkevich.tproger_demo.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void addBook(Book book);
    List<Book> findByAuthor(String author);
}
