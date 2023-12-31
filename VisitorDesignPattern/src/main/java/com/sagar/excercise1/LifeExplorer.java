package com.sagar.excercise1;

public class LifeExplorer implements Explorer {
    @Override
    public void visit(Mercury mercury) {
        System.out.println("Deploying tools specific to Mercury... exploring life");
    }

    @Override
    public void visit(Mars mars) {
        System.out.println("Deploying tools specific to Mars... exploring life");
    }

    @Override
    public void visit(Saturn saturn) {
        System.out.println("Deploying tools specific to Saturn... exploring life");
    }
    
    @Override
    public void visit(Planet planet) {
        System.out.println("Cannot explore life on an unknown planet...");
    }
}