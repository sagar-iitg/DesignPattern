package com.sagar.excercise1;

public interface Explorer {
    void visit(Mercury mercury);
    void visit(Mars mars);
    void visit(Saturn saturn);
    
    default void visit(Planet planet) {
        System.out.println("Landed on an unknown planet...");
        }
}