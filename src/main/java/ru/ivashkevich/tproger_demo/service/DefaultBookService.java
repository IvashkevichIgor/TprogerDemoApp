package ru.ivashkevich.tproger_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ivashkevich.tproger_demo.dao.BookEntity;
import ru.ivashkevich.tproger_demo.dao.BookRepository;
import ru.ivashkevich.tproger_demo.exception.BookNotFoundException;
import ru.ivashkevich.tproger_demo.mapper.BookToEntityMapper;
import ru.ivashkevich.tproger_demo.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> entities = bookRepository.findAll();

        List<Book> bookList = new ArrayList<>();
        for (BookEntity entity : entities) {
            bookList.add(mapper.bookEntityToBook(entity));
        }
        return bookList;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(mapper.bookToBookEntity(book));
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }
}
