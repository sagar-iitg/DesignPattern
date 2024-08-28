package com.sagar.example;


public class ElaichiChai extends ChaiDecorator {
    public ElaichiChai(Chai chai) {
        super(chai);
    }

    @Override
    public String makeChai() {
        return decoratedChai.makeChai() + " + Elaichi (Cardamom)";
    }
}