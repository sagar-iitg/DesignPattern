package com.sagar.excercise3;

// Client code
public class Main {
    public static void main(String[] args) {
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();
        Visitor visitor = new ConcreteVisitor();

        elementA.accept(visitor);  // Output: Visited ConcreteElementA
        elementB.accept(visitor);  // Output: Visited ConcreteElementB
    }
}
