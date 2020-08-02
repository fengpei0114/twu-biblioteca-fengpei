package com.twu.biblioteca.bean;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaHasList {
    private static List<Book> bibliotecaBooks = new ArrayList<>();
    private static List<Movie> bibliotecaMovies = new ArrayList<>();
    public static List<Movie> getBibliotecaMovies() {
        bibliotecaMovies.add(new Movie("schindler's list","1993","Steven Allan Spielberg",9.5,1));
        bibliotecaMovies.add(new Movie("Leon","1994","Luc Besson",9.4,1));
        bibliotecaMovies.add(new Movie("The lord of the ring","2001","Peter Jackson",9.0,1));
        bibliotecaMovies.add(new Movie("Brave heart","1995","Mel Gibson",8.9,1));
        bibliotecaMovies.add(new Movie("Final Destination 1","2000","James wong",7.8,2));
        bibliotecaMovies.add(new Movie("Kill Bill 2","2004","Quentin Tarantino",8.9,1));
        return bibliotecaMovies;
    }
    public static List<Book> getBibliotecaBooks() {
        bibliotecaBooks.add(new Book("Java","JK","1990",1));
        bibliotecaBooks.add(new Book("C#","JK","1991",1));
        bibliotecaBooks.add(new Book("React","JK","1992",1));
        bibliotecaBooks.add(new Book("Angular","JK","1993",2));
        bibliotecaBooks.add(new Book("JavaScript","JK","1994",1));
        bibliotecaBooks.add(new Book("HTML","JK","1995",1));
        return bibliotecaBooks;
    }
}
