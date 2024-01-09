package com.sagar.exmaple2;

public class EmailNotification implements  Notification{

    @Override
    public void notifyUser() {
        System.out.println("Email Notification");
    }
}
