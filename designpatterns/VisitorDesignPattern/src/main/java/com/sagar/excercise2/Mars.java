package com.sagar.excercise2;

public class Mars implements Planet {
    @Override
    public void accept(Explorer explorer) {
        explorer.visit((com.sagar.excercise1.Planet) this);
    }
}