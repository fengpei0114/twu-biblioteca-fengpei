package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.bean.BibliotecaHasList;
import com.twu.biblioteca.bean.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movieList = new ArrayList<>();
    private List<Movie> canCheckOutMovieList = new ArrayList<>();

    public MovieService(){
        this.movieList = new BibliotecaHasList().getBiblotecaMovies();
    }

    public List<Movie> GetCanCheckOutMovieList() {
        this.canCheckOutMovieList = movieList.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
        return canCheckOutMovieList;
    }

}
