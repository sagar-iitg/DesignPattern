package com.sagar;

import lombok.Getter;
import lombok.Setter;


class Product {



    private String name;
    private double price;

    public Product(String name,double price)
    {
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


}





