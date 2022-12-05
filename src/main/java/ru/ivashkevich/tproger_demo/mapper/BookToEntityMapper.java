package ru.ivashkevich.tproger_demo.mapper;

import org.mapstruct.Mapper;
import ru.ivashkevich.tproger_demo.dao.BookEntity;
import ru.ivashkevich.tproger_demo.model.Book;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}
