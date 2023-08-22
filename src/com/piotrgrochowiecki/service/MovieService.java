package com.piotrgrochowiecki.service;

import com.piotrgrochowiecki.entitiy.Book;
import com.piotrgrochowiecki.entitiy.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    Predicate<Movie> isRatingAbove8p0 = m -> m.getRating() > 8.0;

    BiFunction<Movie, Movie, List<String>> findCommonGenresFunction = (m1, m2) -> {
        return m1.getGenres().stream()
                .filter(m2.getGenres()::contains)
                .toList();
    };

    Function<List<Movie>, Map<String, List<Movie>>> groupByDirectorFunction = movies -> movies.stream()
            .collect(Collectors.groupingBy(Movie::getDirector));

    Function<List<Movie>, Double> getAverageRatingFunction = movies -> movies.stream()
            .mapToDouble(Movie::getRating)
            .average()
            .orElse(0.0);

    Function<List<Movie>, Map<String, Double>> getMapOfTitlesAndRatings = movies -> movies.stream()
            .collect(Collectors.toMap(Movie::getTitle, Movie::getRating));

    Comparator<Book> bookByYearPublishedComparator = (b1, b2) -> b2.getYearPublished() - b1.getYearPublished();

    public List<String> getBookSortedByYearPublishedInUpperCase(List<Book> inputList) {
        return inputList.stream()
                .sorted(bookByYearPublishedComparator)
                .map(b -> b.getTitle().toUpperCase())
                .collect(Collectors.toList());
    }
}
