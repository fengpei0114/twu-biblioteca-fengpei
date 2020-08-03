package com.twu.biblioteca.service;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;
import com.twu.biblioteca.bean.User;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService;
    private PrintStream console = null;
    private ByteArrayOutputStream bytes = null;

    @Before
    public void before(){
        bytes = new ByteArrayOutputStreamEx();
        console = System.out;
        System.setOut(new PrintStream(bytes));
    }

    /**
      *@author fengpei
      *@Description 测试Login方法，当顾客存在的情况
      **/
    @Test
    public void testLogin_Customer() {
        User user = new User("234-2345","123456");
        userService = new UserService();

        int result = userService.Login(user);

        assertEquals(0,result);
    }

    /**
     *@author fengpei
     *@Description 测试Login方法，当管理员存在的情况
     **/
    @Test
    public void testLogin_Admin() {
        User user = new User("123-1231","123456");
        userService = new UserService();

        int result = userService.Login(user);

        assertEquals(1,result);
    }

    /**
     *@author fengpei
     *@Description 测试Login方法，当用户不存在时
     **/
    @Test
    public void testLoginUnSuccessful() {
        User user = new User("1231211","123456");
        userService = new UserService();

        int result = userService.Login(user);
        assertEquals(-1,result);
    }

    /**
      *@author fengpei
      *@Description 测试getUserInformantion方法
      **/
    @Test
    public void testgetUserInformation() {
        User user = new User("234-2345","123456");
        userService = new UserService();

        userService.ShowUserInformation(user);

        assertThat(bytes.toString().trim().replace("\r",""), containsString("Jane"));
        assertThat(bytes.toString().trim().replace("\r",""), containsString("13976846500"));
    }

    /**
      *@author fengpei
      *@Description 测试ShowCheckoutBookList方法
      **/
    @Test
    public void testShowCheckoutBookList() {
        userService = new UserService();

        userService.ShowCheckoutBookList();

        assertThat(bytes.toString().trim().replace("\r",""), containsString("React       JK            1992            Jane            2343@163.com    13976846500 "));
    }
}