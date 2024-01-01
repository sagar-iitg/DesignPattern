package com.sagar.example2;

import java.util.ArrayList;
import java.util.List;


//Subject Class
//Publisher Class
public class Group {

    List<Subscriber> users=new ArrayList<>();
    public void subscribe(Subscriber user){
        users.add(user);
    }
    public void unsubscribe(Subscriber user){
        users.remove(user);
    }

    public void notify(String msg) {
        for (Subscriber i:users) {
                i.notify(msg);
            
        }

    }
}
