package com.twu.biblioteca.util;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.bean.User;
import jdk.internal.util.xml.impl.Input;
import org.junit.Test;
import org.mockito.Mockito;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetInputMsgUtilTest {

    /**
     *@author fengpei
     *@Description 测试GetBook方法
     **/
    @Test
    public void testGetBookFunction() {
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        GetInputMsgUtil getInputMsgUtil = new GetInputMsgUtil();
        when(mockInput.getString((String)Mockito.any())).thenReturn("test1").thenReturn("test2").thenReturn("test3");

        getInputMsgUtil.setInputUtil(mockInput);
        Book book = getInputMsgUtil.getBook();

        Book expect = new Book("test1","test2","test3");
        assertThat(expect, is(book));
    }

    /**
      *@author fengpei
      *@Description 测试GetMovie方法
      **/
    @Test
    public void testGetMovieFunction() {
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        GetInputMsgUtil getInputMsgUtil = new GetInputMsgUtil();
        when(mockInput.getString((String)Mockito.any())).thenReturn("test1").thenReturn("test2").thenReturn("test3");

        getInputMsgUtil.setInputUtil(mockInput);
        Movie movie = getInputMsgUtil.getMovie();

        Movie expect = new Movie("test1","test2","test3");
        assertThat(expect, is(movie));
    }

    /**
      *@author fengpei
      *@Description 测试GetUser方法
      **/
    @Test
    public void testGetUserFunction() {
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        GetInputMsgUtil getInputMsgUtil = new GetInputMsgUtil();
        when(mockInput.getString((String)Mockito.any())).thenReturn("test1").thenReturn("test2");

        getInputMsgUtil.setInputUtil(mockInput);
        User user = getInputMsgUtil.getUser();

        User expect = new User("test1","test2");
        assertThat(expect, is(user));
    }
}