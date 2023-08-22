package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Book;
import com.piotrgrochowiecki.entitiy.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class BookService {

    Predicate<Book> isPublishedAfter2000 = book -> book.getYearPublished() > 2000;

    Consumer<Book> printTitleAndAuthor = book -> System.out.println("Title: " + book.getTitle() + " " + book.getAuthor());

    UnaryOperator<Book> increasePublishingYearByOneOperator = book -> {
        int yearOfPublishing = book.getYearPublished();
        book.setYearPublished(yearOfPublishing + 1);
        return book;
    };

    BinaryOperator<Person> combineTwoPersonAddressesOperator = (p1, p2) -> {
        String newAddress = p1.getAddress() + " " + p2.getAddress();
        return new Person("name", 25, newAddress);
    };

    BiPredicate<Book, Book> doBooksHaveTheSameAuthorPredicate = (book1, book2) -> book1.getAuthor().equals(book2.getAuthor());

    ToIntFunction<Book> yearsFromPublishingYearFunction = b -> LocalDate.now().getYear() - b.getYearPublished();

    ToDoubleFunction<Book> averageLengthOfTheTitleAndAuthorFunction = b -> (double) (Math.addExact(b.getTitle().length(), b.getAuthor().length())) /2;

    ObjDoubleConsumer<Book> increaseBookPriceByPercentConsumer = ((book, value) -> book.setPrice((book.getPrice()) * (1 + (value/100))));

    public Book getBookWithHighestNumberOfPages(List<Book> inputList) {
        return inputList.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public Map<String, List<Book>> getMapOfAuthorsAndTheirBooksSortedByYearPublishedAsc(List<Book> inputList) {
        return inputList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.collectingAndThen(Collectors.toList(), books -> books.stream()
                        .sorted((b1, b2) -> b2.getYearPublished() - b1.getYearPublished())
                        .collect(Collectors.toList()))));
    }
}
