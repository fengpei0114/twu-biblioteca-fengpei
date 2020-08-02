package com.twu.biblioteca;

import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.service.MovieService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {

    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private BibliotecaApp bibliotecaApp = null;


    @Before
    public void before() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    /**
     *@author fengpei
     *@Description 测试welcome成功情况
     **/
    @Test
    public void testShouldPrintWelcomeMsg(){
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.welcome();

        String expected = new String("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
    }

    /**
     *@author fengpei
     *@Description 测试ChoosePart方法传入无效数字情况
     **/
    @Test
    public void testChooseInvalidNumberForNextStep() {
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.choosePart(10);

        String expected = new String("Please select a valid option");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }

    /**
     *@author fengpei
     *@Description 测试ChoosePart方法传入有效数字情况
     **/
    @Test
    public void testChooseValidNumberForNextStep() {
        BookService mockbookservice = Mockito.mock(BookService.class);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(mockbookservice);
        bibliotecaApp.choosePart(1);

        Mockito.verify(mockbookservice,Mockito.times(1)).ShowBooks();
    }

    /**
     *@author fengpei
     *@Description 测试CheckoutBook方法，存在图书的情况
     **/
    @Test
    public void testCheckoutBookSuccessful(){
        BookService bookservice = Mockito.mock(BookService.class);
        when(bookservice.CheckOutBook((Book)Mockito.any())).thenReturn(true);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(bookservice);
        bibliotecaApp.ChooseCheckoutBook((Book)Mockito.any());

        String expected = new String("Thank you! Enjoy the book");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }
    /**
     *@author fengpei
     *@Description 测试CheckoutBook方法，不存在图书的情况
     **/
    @Test
    public void testCheckoutBookUnSuccessful(){
        BookService bookservice = Mockito.mock(BookService.class);
        when(bookservice.CheckOutBook((Book)Mockito.any())).thenReturn(false);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(bookservice);
        bibliotecaApp.ChooseCheckoutBook((Book)Mockito.any());

        String expected = new String("sorry,the book is not available");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }
    /**
     *@author fengpei
     *@Description 测试ReturnBook方法成功情况
     **/
    @Test
    public void testReturnBookSuccessful(){
        BookService bookservice = Mockito.mock(BookService.class);
        when(bookservice.ReturnBook((Book)Mockito.any())).thenReturn(true);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(bookservice);
        bibliotecaApp.ChooseReturnBook((Book)Mockito.any());

        String expected = new String("Thank you for returning the book");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }

    /**
     *@author fengpei
     *@Description 测试ReturnBook方法不成功情况
     **/
    @Test
    public void testReturnBookUnSuccessful(){
        BookService bookservice = Mockito.mock(BookService.class);
        when(bookservice.ReturnBook((Book)Mockito.any())).thenReturn(false);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(bookservice);
        bibliotecaApp.ChooseReturnBook((Book)Mockito.any());

        String expected = new String("That is not a valid book to return");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }

    /**
      *@author fengpei
      *@Description 测试ChooseCheckoutMovie方法，存在电影的情况
      **/
    @Test
    public void testChooseCheckoutMovieSuccessful() {
        MovieService mockmovieService = Mockito.mock(MovieService.class);
        when(mockmovieService.CheckOutMovie((Movie)Mockito.any())).thenReturn(true);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setMovieService(mockmovieService);
        bibliotecaApp.ChooseCheckoutMovie((Movie)Mockito.any());

        String expect = new String("Thank you! Enjoy the movie");
        assertEquals(expect, bytes.toString().trim().replace("\r",""));
    }

    /**
     *@author fengpei
     *@Description 测试ChooseCheckoutMovie方法，电影不存在或没有的情况
     **/
    @Test
    public void testChooseCheckoutMovieUnSuccessful() {
        MovieService mockmovieService = Mockito.mock(MovieService.class);
        when(mockmovieService.CheckOutMovie((Movie)Mockito.any())).thenReturn(false);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setMovieService(mockmovieService);
        bibliotecaApp.ChooseCheckoutMovie((Movie)Mockito.any());

        String expect = new String("sorry,the movie is not available");
        assertEquals(expect, bytes.toString().trim().replace("\r",""));
    }

    @After
    public void After() {
        System.setOut(console);
    }
}