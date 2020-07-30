package com.twu.biblioteca;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.service.BookList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class BooklistTest {
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;
    private BookList booklist = new BookList();
    private List<Book> books = null;

    @Before
    public void before() {
        bytes = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    @Test
    public void bookListTest() {

        books = booklist.GetBookList();
        assertNotNull(books);
        assertThat(books, hasItem(new Book("Java","JK","1990",3)));
    }

    @Test
    public void bookAuthor_PublicationYear() {
        books = booklist.GetBookList();
        assertThat(books.get(1).getBookAuthor(),is("JK"));
        assertThat(books.get(2).getBookPublicationYear(), is("1992"));
    }

    @Test
    public void checkOutBookSuccessful(){
        books = booklist.GetBookList();
        Book book = books.get(1);
        int num_old = book.getBookNum();
        booklist.CheckOutBook(book);
        int num_new = book.getBookNum();
        String expected = new String("Thank you! Enjoy the book");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
        assertEquals(num_old-1, num_new);
    }


    @Test
    public void checkOutBookUnsuccessful(){
        books = booklist.GetBookList();
        Book book = new Book("Java","JK","1922");
        booklist.CheckOutBook(book);
        String expected = new String("sorry,the book is not available");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
    }

    @Test
    public void ReturnBookSuccessful() {
        books = booklist.GetBookList();
        Book book = books.get(1);
        int num_old = book.getBookNum();
        booklist.ReturnBook(book);
        int num_new = book.getBookNum();
        String expected = new String("Thank you for returning the book");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
        assertEquals(num_old+1, num_new);
    }

    @Test
    public void ReturnBookUnsuccessful() {
        books = booklist.GetBookList();
        Book book = new Book("test","test","test");
        booklist.ReturnBook(book);
        String expected = new String("That is not a valid book to return");
        assertEquals(expected, bytes.toString().trim().replace("\r",""));
    }


    @After
    public void after(){
        System.setOut(console);
    }
}
