package com.twu.biblioteca.util;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.bean.User;

public class GetInputMsgUtil {
    private Book book;
    private Movie movie;
    private User user;
    private InputUtil inputUtil = new InputUtil();

    public void setInputUtil(InputUtil inputUtil) {
        this.inputUtil = inputUtil;
    }
    /**
      *@author fengpei
      *@Description 通过用户的输入获取用户需要进行操作的图书
      *@Param none
      *@Return Book：用户需要进行操作的图书
      **/
    public Book getBook() {
        String name = this.inputUtil.getString("please write book name： ");
        String author = this.inputUtil.getString("please write book author: ");
        String pub_year = this.inputUtil.getString("please write publication_year: ");
        this.book = new Book(name, author, pub_year);
        return book;
    }

    public GetInputMsgUtil() {
    }

    public Movie getMovie() {
        String name = this.inputUtil.getString("please write movie name： ");
        String year = this.inputUtil.getString("please write movie year： ");
        String director = this.inputUtil.getString("please write movie director： ");
        this.movie = new Movie(name,year,director);
        return movie;
    }

    public User getUser() {
        String library_number = this.inputUtil.getString("please write library number： ");
        String password = this.inputUtil.getString("please write password： ");

        this.user = new User(library_number,password);
        return user;
    }
}
