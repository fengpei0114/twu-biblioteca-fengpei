package com.twu.biblioteca.util;

import com.twu.biblioteca.bean.Book;

public class InputBookUtil {
    private Book book;
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

    public InputBookUtil() {
    }
}
