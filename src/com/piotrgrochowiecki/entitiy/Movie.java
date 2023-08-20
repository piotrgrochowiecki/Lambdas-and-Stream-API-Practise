package com.piotrgrochowiecki.entitiy;

import java.util.List;

public class Movie {

    private String title;
    private String director;
    private int yearReleased;
    private List<String> genres;
    private double rating;

    public Movie(String title, String director, int yearReleased, List<String> genres, double rating) {
        this.title = title;
        this.director = director;
        this.yearReleased = yearReleased;
        this.genres = genres;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;

        if (getYearReleased() != movie.getYearReleased()) return false;
        if (Double.compare(getRating(), movie.getRating()) != 0) return false;
        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDirector() != null ? !getDirector().equals(movie.getDirector()) : movie.getDirector() != null)
            return false;
        return getGenres() != null ? getGenres().equals(movie.getGenres()) : movie.getGenres() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getDirector() != null ? getDirector().hashCode() : 0);
        result = 31 * result + getYearReleased();
        result = 31 * result + (getGenres() != null ? getGenres().hashCode() : 0);
        temp = Double.doubleToLongBits(getRating());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", yearReleased=" + yearReleased +
                ", genres=" + genres +
                ", rating=" + rating +
                '}';
    }
}
