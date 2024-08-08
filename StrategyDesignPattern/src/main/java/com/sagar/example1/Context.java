package com.sagar.example1;

public class Context {
    SortingStrategy sortingStrategy;

    Context(SortingStrategy sortingStrategy){
        this.sortingStrategy=sortingStrategy;
    }
    public void executeStrategy(int[] arr){
        sortingStrategy.sort(arr);
    }
}
