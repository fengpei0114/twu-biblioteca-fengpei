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
    /**
     *@author fengpei
     *@Description 获取目前馆内可以被借的电影列表
     *@Param none
     *@Return List<Movie>：电影列表
     **/
    public List<Movie> GetCanCheckOutMovieList() {
        this.canCheckOutMovieList = this.movieList.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
        return canCheckOutMovieList;
    }
    /**
     *@author fengpei
     *@Description 展示本图书馆里可以被借的所有电影
     *@Param none
     *@Return none
     **/
    public void ShowMovies() {
        System.out.println(" ------------------------------------Movie LIST------------------------------------");
        System.out.printf("%-5s","| ");
        System.out.printf("%-25s","Movie name");
        System.out.printf("%-10s","Year");
        System.out.printf("%-28s","Director");
        System.out.printf("%-12s","Movie rating");
        System.out.printf("  |");
        System.out.println();
        System.out.println(" ----------------------------------------------------------------------------------");
        for(int i=0,j=1; i < this.canCheckOutMovieList.size(); i++){
            System.out.printf("%-5s","| ");
            System.out.printf("%-25s",this.canCheckOutMovieList.get(i).getName());
            System.out.printf("%-10s",this.canCheckOutMovieList.get(i).getYear());
            System.out.printf("%-28s",this.canCheckOutMovieList.get(i).getDirector());
            System.out.printf("%-12s",this.canCheckOutMovieList.get(i).getMovie_rating());
            System.out.printf("  |");
            System.out.println();
        }
        System.out.println(" ----------------------------------------------------------------------------------");
    }
    /**
     *@author fengpei
     *@Description 检查要借的电影是否存在
     *@Param Movie：要借的电影
     *@Return true：存在，可以借；false：不存在，不能借
     **/
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

}
