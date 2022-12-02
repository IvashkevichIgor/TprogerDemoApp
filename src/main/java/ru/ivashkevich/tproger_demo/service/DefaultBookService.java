package ru.ivashkevich.tproger_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivashkevich.tproger_demo.dao.BookEntity;
import ru.ivashkevich.tproger_demo.dao.BookRepository;
import ru.ivashkevich.tproger_demo.exception.BookNotFoundException;
import ru.ivashkevich.tproger_demo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));
        return new Book(bookEntity.getId(), bookEntity.getAuthor(), bookEntity.getTitle(), bookEntity.getPrice());
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> entities = bookRepository.findAll();

        List<Book> bookList = new ArrayList<>();
        for (BookEntity entity : entities) {
            bookList.add(new Book(entity.getId(), entity.getAuthor(), entity.getTitle(), entity.getPrice()));
        }
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity(null, book.getAuthor(), book.getTitle(), book.getPrice());
        bookRepository.save(bookEntity);
    }
}
