package com.sagar.example2;

import com.sagar.example2.factory.CarFactory;
import com.sagar.example2.factory.HondaFactory;
import com.sagar.example2.factory.TataFactory;
import com.sagar.example2.product.SUV;
import com.sagar.example2.product.Sedan;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        CarFactory hondaFactory = new HondaFactory();
        SUV hondaSUV = hondaFactory.createSUV();
        Sedan hondaSedan = hondaFactory.createSedan();

        hondaSUV.build();
        hondaSedan.build();

        CarFactory tataFactory = new TataFactory();
        SUV tataSUV = tataFactory.createSUV();
        Sedan tataSedan = tataFactory.createSedan();

        tataSUV.build();
        tataSedan.build();
    }
}
