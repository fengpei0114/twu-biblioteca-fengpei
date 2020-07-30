package com.twu.biblioteca;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.service.BookList;
import com.twu.biblioteca.util.InputUtil;

public class BibliotecaApp {

    BookList books = new BookList();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.welcome();
        System.out.println("1.浏览全部图书\n2.借书\n3.还书\n4.退出系统");

        while(true){
            int choose = InputUtil.getInt("please enter number which you want to do: ");
            bibliotecaApp.choosePart(choose);
            if(choose == 4) return;
        }
    }
    public void choosePart(int choose){
            switch (choose) {
                case 1: {
                    books.ShowBooks();
                    break;
                }
                case 2: {
                    books.ShowBooks();
                    String name = InputUtil.getString("please write book name： ");
                    String author = InputUtil.getString("please write book author: ");
                    String pub_year = InputUtil.getString("please write publication_year: ");
                    Book book = new Book(name, author, pub_year,1);
                    books.CheckOutBook(book);
                    break;
                }
                case 3: {
                    String name = InputUtil.getString("please write book name： ");
                    String author = InputUtil.getString("please write book author: ");
                    String pub_year = InputUtil.getString("please write publication_year: ");
                    Book book = new Book(name, author, pub_year,1);
                    books.ReturnBook(book);
                    break;
                }
                case 4 : break;
                default:{
                    System.out.println("Please select a valid option");
                }
            }
        }

    public void welcome(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
