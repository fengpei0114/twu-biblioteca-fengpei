package com.twu.biblioteca.service;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private List<Book> booklist = new ArrayList<>();
    public BookList(){
        booklist.add(new Book("Java","JK","1990",1));
        booklist.add(new Book("C#","JK","1991",1));
        booklist.add(new Book("React","JK","1992",1));
        booklist.add(new Book("Angular","JK","1993",1));
        booklist.add(new Book("JavaScript","JK","1994",1));
        booklist.add(new Book("HTML","JK","1995",1));
    }
    public void ShowBooks() {
        System.out.println("------------BOOK LIST-----------------");
        for(int i=0,j=1; i < booklist.size(); i++){
            if(booklist.get(i).getBookNum() != 0){
                System.out.println((j++) + ". " + booklist.get(i).getBookName() + "  " + booklist.get(i).getBookAuthor() + "  " + booklist.get(i).getBookPublicationYear());
            }
        }
        System.out.println("--------------------------------------");
    }
    public List<Book> GetBookList(){
        return this.booklist;
    }
    public void CheckOutBook(Book book) {
        for(int i = 0; i< booklist.size(); i++){
            if(booklist.get(i).equals(book) && booklist.get(i).getBookNum() != 0){
                System.out.println("Thank you! Enjoy the book");
                booklist.get(i).setBookNum(booklist.get(i).getBookNum() - 1);
                return;
            }
        }
        System.out.println("sorry,the book is not available");
    }
    public void ReturnBook(Book book){
        for(int i = 0; i < booklist.size(); i++){
            if(booklist.get(i).equals(book)){
                booklist.get(i).setBookNum(booklist.get(i).getBookNum() + 1);
                System.out.println("Thank you for returning the book");
                return;
            }
        }
        System.out.println("That is not a valid book to return");
    }
}
