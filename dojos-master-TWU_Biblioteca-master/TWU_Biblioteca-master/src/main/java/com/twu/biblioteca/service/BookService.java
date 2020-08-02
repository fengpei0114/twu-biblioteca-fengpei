package com.twu.biblioteca.service;

import com.twu.biblioteca.bean.BibliotecaHasList;
import com.twu.biblioteca.bean.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> booklist;
    private List<Book> CanCheckoutBook = new ArrayList<>();

    public BookService(){
        CanCheckoutBook = booklist = new BibliotecaHasList().getBibliotecaBooks();
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
        int index = this.booklist.indexOf(book);
        if(index != -1 && this.booklist.get(index).getNum() != 0){
            this.booklist.get(index).setNum(this.CanCheckoutBook.get(index).getNum() - 1);
            this.CanCheckoutBook = this.booklist.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
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
        int index = this.booklist.indexOf(book);

        if(index != -1){
            this.booklist.get(index).setNum(this.booklist.get(index).getNum() + 1);
            this.CanCheckoutBook = this.booklist.stream().filter(p -> p.getNum() != 0).collect(Collectors.toList());
            return true;
        }
        return false;
    }

}
