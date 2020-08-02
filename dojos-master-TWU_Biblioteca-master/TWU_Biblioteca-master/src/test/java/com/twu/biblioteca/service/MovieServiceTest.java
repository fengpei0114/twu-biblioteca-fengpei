package com.twu.biblioteca.service;



import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import com.twu.biblioteca.bean.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class MovieServiceTest {
    private MovieService movieService;
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private List<Movie> movieList = null;

    @Before
    public void before() {
        bytes = new ByteArrayOutputStreamEx();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void testGetCanCheckOutMovieList() {
        movieService = new MovieService();

        List<Movie> movieList = movieService.GetCanCheckOutMovieList();
        List<Movie> expand = movieList.stream().filter(p -> p.getNum() == 0).collect(Collectors.toList());

        assertEquals(0,expand.size());
    }

    /**
     *@author fengpei
     *@Description 测试ShowMovies方法是否被输出
     **/
    @Test
    public void testShowMovies(){
        movieService = new MovieService();

        movieService.ShowMovies();

        assertThat(bytes.toString().trim().replace("\r",""),containsString("schindler's list   1993   Steven Allan Spielberg   9.5"));
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutMovie方法成功的情况，即电影存在,且数量为1
     **/
    @Test
    public void testCheckOutOnlyMovieSuccessful() {
        Movie movie = new Movie("Brave heart","1995","Mel Gibson");
        movieService = new MovieService();

        Boolean isSuccess = movieService.CheckOutMovie(movie);
        movieList = movieService.GetCanCheckOutMovieList();
        Boolean isHaveMovie = movieList.contains(movie);

        assertEquals(true, isSuccess);
        assertEquals(false, isHaveMovie);
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutMovie方法成功的情况，即电影存在,且数量不止1本
     **/
    @Test
    public void testCheckOutMovieSuccessful() {
        Movie movie = new Movie("Final Destination 1","2000","James wong");
        movieService = new MovieService();

        Boolean isSuccess = movieService.CheckOutMovie(movie);
        movieList = movieService.GetCanCheckOutMovieList();
        Boolean isHaveMovie = movieList.contains(movie);

        assertEquals(true, isHaveMovie);
        assertEquals(true, isSuccess);
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutMovie方法不成功的情况，即电影不存在
     **/
    @Test
    public void testCheckOutMovieUnSuccessful() {
        Movie movie = new Movie("schindler's list","1991","Steven Allan Spielberg");
        movieService = new MovieService();

        Boolean isHaveMovie = movieService.CheckOutMovie(movie);
        assertEquals(false, isHaveMovie);
    }

}