package com.twu.biblioteca.service;

import com.twu.biblioteca.bean.BibliotecaHasList;
import com.twu.biblioteca.bean.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movieList;
    private List<Movie> canCheckOutMovieList = new ArrayList<>();

    public MovieService(){
        canCheckOutMovieList = movieList = new BibliotecaHasList().getBibliotecaMovies();
    }

    public List<Movie> GetCanCheckOutMovieList() {
        this.canCheckOutMovieList = this.movieList.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
        return canCheckOutMovieList;
    }

    public void ShowMovies() {
        System.out.println("------------Movie LIST-----------------");
        for(int i=0,j=1; i < this.canCheckOutMovieList.size(); i++){
            System.out.println((j++) + ". " + this.canCheckOutMovieList.get(i).getName() + "   " + this.canCheckOutMovieList.get(i).getYear() + "   " + this.canCheckOutMovieList.get(i).getDirector() + "   " + this.canCheckOutMovieList.get(i).getMovie_rating());
        }
        System.out.println("--------------------------------------");
    }

    public Boolean CheckOutMovie(Movie movie) {
        int index = this.movieList.indexOf(movie);
        if(index != -1) {
            this.movieList.get(index).setNum(this.movieList.get(index).getNum() - 1);
            if(movieList.get(index).getNum() == 0)
                this.canCheckOutMovieList.remove(index);
            return true;
        }
        return false;
    }

//    public int findMovie(Movie movie){
//        this.canCheckOutMovieList.indexOf(movie);
//        if(findmovie.size() != 0){
//            return
//        }
//        return -1;
//    }
}
