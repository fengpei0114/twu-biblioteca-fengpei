package com.twu.biblioteca.bean;

import java.util.Objects;

public class Movie {
    private String name;
    private String year;
    private String director;
    private Double movie_rating;
    private int num;

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public Double getMovie_rating() {
        return movie_rating;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Movie(String name, String year, String director, Double movie_rating, int num) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movie_rating = movie_rating;
        this.num = num;
    }
    public Movie(String name, String year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", director='" + director + '\'' +
                ", movie_rating=" + movie_rating +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director,movie_rating,num);
    }
}
