package com.sagar.exmaple2;

public class Main {


    public static void main(String[] args) {


        Notification notification=NotificationFactory.createNotification("sma");
        notification.notifyUser();

    }
}
