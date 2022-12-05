package ru.ivashkevich.tproger_demo.mapper;

import org.mapstruct.Mapper;
import ru.ivashkevich.tproger_demo.model.Book;
import ru.ivashkevich.tproger_demo.model.BookDTO;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book bookDtoToBook(BookDTO bookDTO);
}
