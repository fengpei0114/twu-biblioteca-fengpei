package com.twu.biblioteca.util;


import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    /**
      *@author fengpei
      *@Description 获得键盘输入的一个数字，若不是数字则告知用户并进行重新输入
      *@Param msg：展示给用户以获得用户输入信息的文字
      *@Return int：用户输入的数字
      **/
    public int getInt(String msg) {
        while(true){
            try{
                System.out.print(msg);
                return Integer.parseInt(scanner.next());
            }catch (NumberFormatException e) {
                System.out.println("you allowed input number, please try it again!");
            }
        }
    }
    /**
      *@author fengpei
      *@Description 获得键盘输入的一串字符
      *@Param msg：展示给用户以获取用户输入信息的文字
      *@Return String：用户输入的字符串
      **/
    public String getString(String msg) {
        scanner.useDelimiter("\n");
        System.out.print(msg);
        String string = scanner.next();
        return string;
    }
}
