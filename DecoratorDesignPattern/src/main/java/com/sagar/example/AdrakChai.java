package com.sagar.example;

public class AdrakChai extends ChaiDecorator {
    public AdrakChai(Chai chai) {
        super(chai);
    }
    @Override
    public String makeChai() {
        return decoratedChai.makeChai() + " + Adrak (Ginger)";
    }
}
