package com.sagar.example2;

public class User implements  Subscriber{

    private int userId;

    public User(int userId) {
        this.userId = userId;
    }

    @Override
    public void notify(String msg) {
        System.out.println("User"+ userId+"-"+ msg);
    }
}
