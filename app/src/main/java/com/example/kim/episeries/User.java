package com.example.kim.episeries;

/**
 * Created by kim on 15/03/2016.
 */
public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public  String getPassword() {
        return  password;
    }
}