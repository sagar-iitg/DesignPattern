package com.sagar.example;

public abstract class ChaiDecorator implements  Chai{

    protected Chai decoratedChai;
    public ChaiDecorator(Chai chai) {
        this.decoratedChai=chai;

    }
    @Override
    public  String makeChai(){
        return decoratedChai.makeChai();
    }

}
