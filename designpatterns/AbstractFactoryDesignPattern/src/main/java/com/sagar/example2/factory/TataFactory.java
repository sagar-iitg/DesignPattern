package com.sagar.example2.factory;

import com.sagar.example2.product.SUV;
import com.sagar.example2.product.Sedan;
import com.sagar.example2.tata.TataSUV;
import com.sagar.example2.tata.TataSedan;

public class TataFactory implements CarFactory {
    public SUV createSUV() {
        return new TataSUV();
    }

    public Sedan createSedan() {
        return new TataSedan();
    }
}