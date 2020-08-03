package com.twu.biblioteca;

import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.bean.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.util.InputUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
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

        bibliotecaApp.noLoginChoosePart(10);

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
        bibliotecaApp.noLoginChoosePart(1);

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

    /**
      *@author fengpei
      *@Description 测试UserLogin方法，顾客成功登录的情况
      **/
    @Test
    public void testUserLogin_Customer() {
        UserService mockuserService = Mockito.mock(UserService.class);
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        when(mockuserService.Login((User)Mockito.any())).thenReturn(0);
        when(mockInput.getInt((String)Mockito.any())).thenReturn(10000);

        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setUserService(mockuserService);
        bibliotecaApp.setInputUtil(mockInput);
        bibliotecaApp.UserLogin(Mockito.any());


        assertThat(bytes.toString().trim().replace("\r",""),containsString("Successful!"));
        assertThat(bytes.toString().trim().replace("\r",""),containsString("6.User Information"));
    }

    /**
     *@author fengpei
     *@Description 测试UserLogin方法，图书管理员成功登录的情况
     **/
    @Test
    public void testUserLogin_admin() {
        UserService mockuserService = Mockito.mock(UserService.class);
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        when(mockuserService.Login((User)Mockito.any())).thenReturn(1);
        when(mockInput.getInt((String)Mockito.any())).thenReturn(10000);

        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setUserService(mockuserService);
        bibliotecaApp.setInputUtil(mockInput);
        bibliotecaApp.UserLogin(Mockito.any());


        assertThat(bytes.toString().trim().replace("\r",""),containsString("Successful!"));
        assertThat(bytes.toString().trim().replace("\r",""),containsString("6.Checkout book list"));
    }

    /**
     *@author fengpei
     *@Description 测试UserLogin方法，图书管理员成功登录的情况
     **/
    @Test
    public void testUserLoginUnsuccessful() {
        UserService mockuserService = Mockito.mock(UserService.class);
        when(mockuserService.Login((User)Mockito.any())).thenReturn(-1);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setUserService(mockuserService);
        bibliotecaApp.UserLogin(Mockito.any());

        assertThat(bytes.toString().trim().replace("\r",""),containsString("Sorry,Wrong library_number or password!"));
    }

    @After
    public void After() {
        System.setOut(console);
    }
}