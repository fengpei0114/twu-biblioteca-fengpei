package com.twu.biblioteca.bean;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private String publication_year;
    private int num;

    public Book(String name, String author, String publication_year, int num) {
        this.name = name;
        this.author = author;
        this.publication_year = publication_year;
        this.num = num;
    }

    public Book(String name, String author, String publication_year) {
        this.name = name;
        this.author = author;
        this.publication_year = publication_year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return  Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publication_year, book.publication_year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publication_year, num);
    }
}
