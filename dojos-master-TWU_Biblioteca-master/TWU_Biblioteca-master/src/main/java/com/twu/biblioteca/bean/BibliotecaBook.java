package com.twu.biblioteca.bean;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaBook {
    private static List<Book> bibliotecaBooks = new ArrayList<>();

    public static List<Book> getBibliotecaBooks() {
        return bibliotecaBooks;
    }

    public void setBibliotecaBooks(List<Book> bibliotecaBooks) {
        this.bibliotecaBooks = bibliotecaBooks;
    }

    public BibliotecaBook() {
        bibliotecaBooks.add(new Book("Java","JK","1990",1));
        bibliotecaBooks.add(new Book("C#","JK","1991",1));
        bibliotecaBooks.add(new Book("React","JK","1992",1));
        bibliotecaBooks.add(new Book("Angular","JK","1993",1));
        bibliotecaBooks.add(new Book("JavaScript","JK","1994",1));
        bibliotecaBooks.add(new Book("HTML","JK","1995",1));
    }
}
