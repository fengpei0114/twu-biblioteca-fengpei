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
    private BookService bookservice = new BookService();
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
        books = bookservice.GetCanCheckOutBookList();

        assertThat(books.get(1).getAuthor(),is("JK"));
        assertThat(books.get(2).getPublication_year(), is("1992"));
    }
    /**
     *@author fengpei
     *@Description 测试GetCanCheckOutBookList方法成功情况
     **/
    @Test
    public void testGetCanCheckOutBookList() {
        books = bookservice.GetCanCheckOutBookList();
        List<Book> newTestBooks = books.stream().filter(p -> p.getNum() == 0).collect(Collectors.toList());
        assertEquals(0,newTestBooks.size());
    }

    /**
     *@author fengpei
     *@Description 测试CheckOutBook方法成功情况
     **/
    @Test
    public void testCheckOutBookSuccessful(){
        Book book = new Book("C#","JK","1991");
        boolean IsSuccess = bookservice.CheckOutBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(new Book("C#","JK","1991"));

        assertEquals(true,IsSuccess);
        assertEquals(false,IsHaveBook);
        }

    /**
     *@author fengpei
     *@Description 测试CheckOutBook方法失败情况
     **/
    @Test
    public void testCheckOutBookUnsuccessful(){
        Book book = new Book("Java","JK","1922");

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

        Book book = new Book("test","test","test");

        boolean isSuccess = bookservice.ReturnBook(book);
        books = bookservice.GetCanCheckOutBookList();
        boolean IsHaveBook = books.contains(new Book("test","test","test"));

        assertEquals(false,isSuccess);
        assertEquals(false,IsHaveBook);
    }
    /**
     *@author fengpei
     *@Description 测试FindBook方法成功情况
     **/
    @Test
    public void testFindBookSuccessful() {
        Book book1 = new Book("Java","JK","1990");
        Book book2 = new Book("HTML","JK","1995");
        bookservice = new BookService();

        int index1 = bookservice.findBood(book1);
        int index2 = bookservice.findBood(book2);

        assertEquals(0,index1);
        assertEquals(5,index2);
    }

    /**
     *@author fengpei
     *@Description 测试FindBook方法失败情况
     **/
    @Test
    public void testFindBookUnsuccessful() {
        Book book = new Book("Typora","JK","1992");
        bookservice = new BookService();

        int index = bookservice.findBood(book);

        assertEquals(-1,index);
    }

    @After
    public void after(){
        System.setOut(console);
    }

}