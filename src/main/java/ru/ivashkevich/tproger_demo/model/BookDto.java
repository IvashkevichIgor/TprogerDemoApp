package ru.ivashkevich.tproger_demo.model;

import lombok.Data;

@Data
public class BookDto {
    private String author;
    private String title;
    private Double price;
}
