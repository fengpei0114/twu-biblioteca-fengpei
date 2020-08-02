package com.twu.biblioteca.service;

import com.twu.biblioteca.bean.Book;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BookServiceTest{
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private BookService bookservice;
    private List<Book> books = null;

    @Before
    public void before() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    /**
      *@author fengpei
      *@Description 测试图书列表中是否为空，是否含有某一图书
      **/
    @Test
    public void testBookListTest() {
        bookservice = new BookService();
        books = bookservice.GetCanCheckOutBookList();

        assertNotNull(books);
        assertThat(books, hasItem(new Book("Java","JK","1990",1)));
    }

    /**
      *@author fengpei
      *@Description 测试图书作者和出版年份是否存在
      **/
    @Test
    public void testBookAuthor_PublicationYear() {
        bookservice = new BookService();
        books = bookservice.GetCanCheckOutBookList();

        assertThat(books.get(1).getAuthor(),is("JK"));
        assertThat(books.get(0).getPublication_year(), is("1990"));
    }
    /**
     *@author fengpei
     *@Description 测试GetCanCheckOutBookList方法成功情况
     **/
    @Test
    public void testGetCanCheckOutBookList() {
        bookservice = new BookService();
        books = bookservice.GetCanCheckOutBookList();
        List<Book> newTestBooks = books.stream().filter(p -> p.getNum() == 0).collect(Collectors.toList());
        assertEquals(0,newTestBooks.size());
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutBook方法成功的情况，即图书存在,且数量为1
     **/
    @Test
    public void testCheckOutOnlyBookSuccessful(){
        Book book = new Book("C#","JK","1991");
        bookservice = new BookService();

        boolean IsSuccess = bookservice.CheckOutBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(book);

        assertEquals(true,IsSuccess);
        assertEquals(false,IsHaveBook);
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutBook方法成功的情况，即图书存在,且数量不为1
     **/
    @Test
    public void testCheckOutBookSuccessful(){
        Book book = new Book("Angular","JK","1993",2);
        bookservice = new BookService();

        boolean IsSuccess = bookservice.CheckOutBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(book);

        assertEquals(true,IsSuccess);
        assertEquals(true,IsHaveBook);
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutBook方法失败情况,即图书没有或不存在
     **/
    @Test
    public void testCheckOutBookUnsuccessful(){
        Book book = new Book("Java","JK","1922");
        bookservice = new BookService();

        boolean IsSuccess = bookservice.CheckOutBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(new Book("Java","JK","1990"));

        assertEquals(false,IsSuccess);
        assertEquals(true,IsHaveBook);
    }

    /**
     *@author fengpei
     *@Description 测试ReturnBook方法成功情况
     **/
    @Test
    public void testReturnBookSuccessful() {
        Book book = new Book("C#","JK","1991");
        bookservice = new BookService();

        boolean IsSuccess = bookservice.ReturnBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(new Book("C#","JK","1991"));

        assertEquals(true,IsSuccess);
        assertEquals(true,IsHaveBook);
        }

    /**
     *@author fengpei
     *@Description 测试ReturnBook方法失败情况
     **/
    @Test
    public void testReturnBookUnsuccessful() {
        bookservice = new BookService();
        Book book = new Book("test","test","test");

        boolean isSuccess = bookservice.ReturnBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(new Book("test","test","test"));

        assertEquals(false,isSuccess);
        assertEquals(false,IsHaveBook);
    }

    @After
    public void after(){
        System.setOut(console);
    }

}