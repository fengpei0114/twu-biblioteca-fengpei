package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.bean.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

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

        bibliotecaApp.choosePart(5);

        String expected = new String("Please select a valid option");
        assertEquals(expected,bytes.toString().trim().replace("\r",""));
    }

    /**
     *@author fengpei
     *@Description 测试ChoosePart方法传入有效数字情况
     **/
    @Test
    public void testChooseValidNumberForNextStep() {
        BookService bookservice = Mockito.mock(BookService.class);
        bibliotecaApp = new BibliotecaApp();

        bibliotecaApp.setBookservice(bookservice);
        bibliotecaApp.choosePart(1);

        Mockito.verify(bookservice,Mockito.times(1)).ShowBooks();
    }

    /**
     *@author fengpei
     *@Description 测试CheckoutBook方法成功情况
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
     *@Description 测试CheckoutBook方法不成功情况
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


    @After
    public void After() {
        System.setOut(console);
    }
}