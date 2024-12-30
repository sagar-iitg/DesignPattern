package com.sagar.example1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr={10,20,-9,89};
        SortingStrategy sortingStrategy=new BubbleSort();
        Context context=new Context(sortingStrategy);
        context.executeStrategy(arr);
        System.out.println(Arrays.toString(arr));

    }
}
