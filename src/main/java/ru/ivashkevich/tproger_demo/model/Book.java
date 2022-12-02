package ru.ivashkevich.tproger_demo.model;

import lombok.Value;

@Value              //добавит getters, конструктор со всеми параметрами, пометит все поля класса private final, добавит методы hashCode, equals и toString
public class Book {
    Long id;
    String author;
    String title;
    Double price;
}
