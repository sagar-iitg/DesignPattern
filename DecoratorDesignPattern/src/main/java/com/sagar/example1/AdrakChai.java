package com.sagar.example1;

public class AdrakChai extends ChaiDecorator {
    public AdrakChai(Chai chai) {
        super(chai);
    }
    @Override
    public String makeChai() {
        return decoratedChai.makeChai() + " + Adrak (Ginger)";
    }
}
