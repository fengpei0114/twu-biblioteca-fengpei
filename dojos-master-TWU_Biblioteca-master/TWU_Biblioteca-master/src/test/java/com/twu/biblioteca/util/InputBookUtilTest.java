package com.twu.biblioteca.util;

import com.twu.biblioteca.bean.Book;
import org.junit.Test;
import org.mockito.Mockito;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class InputBookUtilTest {

    /**
     *@author fengpei
     *@Description 测试GetBook方法
     **/
    @Test
    public void testGetBookFunction() {
        InputUtil mockInput = Mockito.mock(InputUtil.class);
        InputBookUtil inputBookUtil = new InputBookUtil();
        when(mockInput.getString((String)Mockito.any())).thenReturn("Java").thenReturn("JK").thenReturn("1990");

        inputBookUtil.setInputUtil(mockInput);
        Book book = inputBookUtil.getBook();

        Book expect = new Book("Java","JK","1990");
        assertThat(expect, is(book));
    }
}