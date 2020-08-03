package com.twu.biblioteca.bean;

import java.util.Objects;

public class User {
    private String name;
    private String email;
    private String phone_number;
    private String library_number;
    private String password;
    private int role; //0 is customer, 1 is administrator

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getLibrary_number() {
        return library_number;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public User(String name, String email, String phone_number, String library_number, String password, int role) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.library_number = library_number;
        this.password = password;
        this.role = role;
    }

    public User(String library_number, String password) {
        this.library_number = library_number;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(library_number, user.library_number) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(library_number, password);
    }
}
