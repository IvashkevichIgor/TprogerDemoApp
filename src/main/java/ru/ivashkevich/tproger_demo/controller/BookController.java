package ru.ivashkevich.tproger_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ivashkevich.tproger_demo.mapper.BookToDtoMapper;
import ru.ivashkevich.tproger_demo.model.Book;
import ru.ivashkevich.tproger_demo.model.BookDto;
import ru.ivashkevich.tproger_demo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List getAllBooks(@RequestParam(required = false) String author){
        if (author != null){
            return bookService.findByAuthor(author);
        }
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookDto bookDto){
        bookService.addBook(mapper.bookDtoToBook(bookDto));
    }
}
