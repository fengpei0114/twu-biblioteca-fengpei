package com.twu.biblioteca.service;



import com.twu.biblioteca.bean.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class MovieServiceTest {
    private MovieService movieService;
    @Test
    public void testGetMovieList() {
        movieService = new MovieService();
        List<Movie> movieList = movieService.GetCanCheckOutMovieList();

        assertNotNull(movieList);
        assertThat(movieList, hasItem(new Movie("schindler's list","1993","Steven Allan Spielberg",9.5,1)));
    }

}