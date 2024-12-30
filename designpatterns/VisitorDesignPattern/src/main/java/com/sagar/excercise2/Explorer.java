package com.sagar.excercise2;

import com.sagar.excercise1.Mars;
import com.sagar.excercise1.Mercury;
import com.sagar.excercise1.Planet;
import com.sagar.excercise1.Saturn;

public interface Explorer {
    void visit(Mercury mercury);
    void visit(Mars mars);
    void visit(Saturn saturn);
    
    default void visit(Planet planet) {
        System.out.println("Landed on an unknown planet...");
        }
}