package com.sagar.exmaple2;

public class NotificationFactory {



    public static Notification createNotification(String channel){


        if(channel.equalsIgnoreCase("email"))
        {
                return new EmailNotification();

        }
        else if(channel.equalsIgnoreCase("Push")){
            return new PushNotification();

        }
        else if(channel.equalsIgnoreCase("sms")){
            return new  SmsNotification();
        }
        else {
            throw new IllegalArgumentException("Unknown channel "+ channel);

        }


    }



}
