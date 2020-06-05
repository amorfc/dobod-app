package com.example.tellee.Models;

public class User {
    private String user_Id;
    private String password;

    public User(String user_Id, String password) {
        this.user_Id = user_Id;
        this.password = password;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public String getPassword() {
        return password;
    }
}
