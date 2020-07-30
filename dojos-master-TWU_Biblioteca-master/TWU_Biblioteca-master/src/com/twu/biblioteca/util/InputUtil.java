package com.twu.biblioteca.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String msg) {
        System.out.print(msg);
        while(true){
            try{
                return Integer.parseInt(scanner.next());
            }catch (NumberFormatException e) {
                System.out.println("you allowed input number, please try it again!");
            }
        }

    }
    public static String getString(String msg) {
        System.out.print(msg);
        return scanner.next();
    }
}
