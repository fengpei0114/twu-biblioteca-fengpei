package com.twu.biblioteca.service;

import com.twu.biblioteca.bean.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> booklist = new ArrayList<>();
    private List<Book> CanCheckoutBook = new ArrayList<>();

    public BookService(){
        booklist.add(new Book("Java","JK","1990",1));
        booklist.add(new Book("C#","JK","1991",1));
        booklist.add(new Book("React","JK","1992",1));
        booklist.add(new Book("Angular","JK","1993",1));
        booklist.add(new Book("JavaScript","JK","1994",1));
        booklist.add(new Book("HTML","JK","1995",1));
        this.CanCheckoutBook = this.booklist;
    }
    /**
      *@author fengpei
      *@Description 展示本图书馆里可以被借的所有图书
      *@Param none
      *@Return none
      **/
    public void ShowBooks() {
        System.out.println("------------BOOK LIST-----------------");
        for(int i=0,j=1; i < this.CanCheckoutBook.size(); i++){
            System.out.println((j++) + ". " + this.CanCheckoutBook.get(i).getName() + "  " + this.CanCheckoutBook.get(i).getAuthor() + "  " + this.CanCheckoutBook.get(i).getPublication_year());
        }
        System.out.println("--------------------------------------");
    }
    /**
      *@author fengpei
      *@Description 获取目前馆内可以被借的图书列表
      *@Param none
      *@Return List<Book>：图书列表
      **/
    public List<Book> GetCanCheckOutBookList(){
        this.CanCheckoutBook = booklist.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
        return this.CanCheckoutBook;
    }
    /**
      *@author fengpei
      *@Description 检查要借的图书是否存在
      *@Param book：要借的图书
      *@Return true：存在，可以借；false：不存在，不能借
      **/
    public boolean CheckOutBook(Book book) {
        if(findBood(book) != -1){
            booklist.get(findBood(book)).setNum(booklist.get(findBood(book)).getNum() - 1);
            this.CanCheckoutBook = booklist.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
            return true;
        }else{
            return false;
        }
    }
    /**
      *@author fengpei
      *@Description 检查要归还的图书是否是本图书馆的
      *@Param book：要归还的图书
      *@Return true：该图书是本图书馆的；false：该图书不是本图书馆的
      **/
    public boolean ReturnBook(Book book){
        if(findBood(book) != -1){
            booklist.get(findBood(book)).setNum(booklist.get(findBood(book)).getNum() + 1);
            this.CanCheckoutBook = booklist.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
            return true;
        }
        return false;
    }
    /**
      *@author fengpei
      *@Description 查找馆内是否有该图书
      *@Param book：被查询的图书
      *@Return int：如果有，返回图书的index，没有则返回-1
      **/
    public int findBood(Book book){
        for(int i = 0; i < booklist.size(); i++){
            if(booklist.get(i).equals(book)){
                return i;
            }
        }
        return -1;
    }

}
