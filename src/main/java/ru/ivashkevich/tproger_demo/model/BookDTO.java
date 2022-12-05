package ru.ivashkevich.tproger_demo.model;

import lombok.Data;

@Data
public class BookDTO {
    private String author;
    private String title;
    private Double price;
}
