package com.sagar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Get an iterator for the List
        Iterator<Integer> iterator = numbers.iterator();

        // Iterate through the elements using the iterator
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println(number);
        }
    }
}
