package com.twu.biblioteca.bean;

import java.util.*;
import java.util.stream.Collectors;

public class BibliotecaHasList {
    private static List<Book> bibliotecaBooks = new ArrayList<>();
    private static List<Movie> bibliotecaMovies = new ArrayList<>();
    private static List<User> bibliotecaUser = new ArrayList<>();
    private static Map<Book,User> bibliotecaCheckoutBook_User = new HashMap<>();

    public static List<Movie> getBibliotecaMovies() {
        bibliotecaMovies.add(new Movie("schindler's list","1993","Steven Allan Spielberg",9.5,1));
        bibliotecaMovies.add(new Movie("Leon","1994","Luc Besson",9.4,1));
        bibliotecaMovies.add(new Movie("The lord of the ring","2001","Peter Jackson",9.0,1));
        bibliotecaMovies.add(new Movie("Brave heart","1995","Mel Gibson",8.9,1));
        bibliotecaMovies.add(new Movie("Final Destination 1","2000","James wong",7.8,2));
        bibliotecaMovies.add(new Movie("Kill Bill 2","2004","Quentin Tarantino",8.9,1));
        return (List) bibliotecaMovies.stream().distinct().collect(Collectors.toList());
    }
    public static List<Book> getBibliotecaBooks() {
        bibliotecaBooks.add(new Book("Java","JK","1990",1));
        bibliotecaBooks.add(new Book("C#","JK","1991",1));
        bibliotecaBooks.add(new Book("React","JK","1992",1));
        bibliotecaBooks.add(new Book("Angular","JK","1993",2));
        bibliotecaBooks.add(new Book("JavaScript","JK","1994",1));
        bibliotecaBooks.add(new Book("HTML","JK","1995",1));
        return bibliotecaBooks.stream().distinct().collect(Collectors.toList());
    }
    public static List<User> getBibliotecaUser() {
        bibliotecaUser.add(new User("Jack","123@google.com","13823985529","123-1231","123456",1));
        bibliotecaUser.add(new User("Jane","2343@163.com","13976846500","234-2345","123456",0));
        return bibliotecaUser;
    }
    public static Map<Book,User> getBibliotecaCheckoutBook_User() {
        Book book1 = new Book("HTML","JK","1995",1);
        Book book2 = new Book("React","JK","1992",1);
        User user = new User("Jane","2343@163.com","13976846500","234-2345","123456",0);
        bibliotecaCheckoutBook_User.put(book1,user);
        bibliotecaCheckoutBook_User.put(book2,user);
        return bibliotecaCheckoutBook_User;
    }
}
