package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Book;

import java.util.ConcurrentModificationException;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BookService {

    Predicate<Book> isPublishedAfter2000 = book -> book.getYearPublished() > 2000;

    Consumer<Book> printTitleAndAuthor = book -> System.out.println("Title: " + book.getTitle() + " " + book.getAuthor());
}
