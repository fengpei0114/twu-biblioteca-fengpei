package com.twu.biblioteca.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class InputUtilTest {

    /**
     *@author fengpei
     *@Description 测试GetInt方法成功情况
     **/
    @Test
    public void testGetIntFunction_Right(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int expect = new InputUtil().getInt("test");
        assertEquals(expect,1);
    }

    /**
     *@author fengpei
     *@Description 测试GetInt方法失败(抛出异常)情况
     **/
    @Test(expected = NumberFormatException.class)
    public void testGetIntFunction_Wrong(){
        String data = "1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        int expect = new InputUtil().getInt("test");
        throw new NumberFormatException("test");
    }

    /**
     *@author fengpei
     *@Description 测试GetString方法
     **/
    @Test
    public void testGetStringFunction(){

        String data = "test";
        System.setIn((new ByteArrayInputStream(data.getBytes())));

        String expect = new InputUtil().getString("test");
        assertEquals(expect, "test");
    }

}