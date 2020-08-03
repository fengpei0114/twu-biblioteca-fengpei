package com.twu.biblioteca.service;


import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.bean.BibliotecaHasList;
import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private List<User> userList = new ArrayList<>();

    public UserService() {
        userList = new BibliotecaHasList().getBibliotecaUser();
    }


    public int Login(User user) {
        int index = userList.indexOf(user);
        if(index != -1){
            new BibliotecaApp().user = userList.get(index);
            System.out.println(new BibliotecaApp().user.getName());
            return userList.get(index).getRole();
        }
        return -1;
    }

    public void ShowUserInformation(User inputUser) {
        User user = userList.get(userList.indexOf(inputUser));
        System.out.println("-------------USER INFORMATION-------------");
        System.out.printf("%-1s","|");
        System.out.printf("%-40s","name: " + user.getName());
        System.out.printf("%1s","|");
        System.out.println();
        System.out.printf("%-1s","|");
        System.out.printf("%-40s","email: " + user.getEmail());
        System.out.printf("%1s","|");
        System.out.println();
        System.out.printf("%-1s","|");
        System.out.printf("%-40s","phone: number: " + user.getPhone_number());
        System.out.printf("%1s","|");
        System.out.println();
        System.out.println("------------------------------------------");

    }

    public void ShowCheckoutBookList() {
        Map<Book,User> checkoutBook_User = new BibliotecaHasList().getBibliotecaCheckoutBook_User();
        System.out.println("--------------------------------------CHECKOUT BOOK LIST--------------------------------------");
        System.out.printf("%-2s", "|");
        System.out.printf("%-12s", "Book Name");
        System.out.printf("%-14s", "Book Author");
        System.out.printf("%-16s", "Book Pub_Year");
        System.out.printf("%-16s", "Customer Name");
        System.out.printf("%-16s", "Customer email");
        System.out.printf("%-16s", "Customer phone");
        System.out.printf("%2s", "|");
        System.out.println();
        checkoutBook_User.forEach((book,user) -> {
            System.out.printf("%-2s", "|");
            System.out.printf("%-12s", book.getName());
            System.out.printf("%-14s", book.getAuthor());
            System.out.printf("%-16s", book.getPublication_year());
            System.out.printf("%-16s", user.getName());
            System.out.printf("%-16s", user.getEmail());
            System.out.printf("%-16s", user.getPhone_number());
            System.out.printf("%2s", "|");
            System.out.println();
        });
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
