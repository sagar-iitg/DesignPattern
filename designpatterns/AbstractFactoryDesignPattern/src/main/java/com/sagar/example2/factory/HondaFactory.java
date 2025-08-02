package com.sagar.example2.factory;

import com.sagar.example2.honda.HondaSUV;
import com.sagar.example2.honda.HondaSedan;
import com.sagar.example2.product.SUV;
import com.sagar.example2.product.Sedan;

public class HondaFactory implements CarFactory {
    public SUV createSUV() {
        return new HondaSUV();
    }

    public Sedan createSedan() {
        return new HondaSedan();
    }
}