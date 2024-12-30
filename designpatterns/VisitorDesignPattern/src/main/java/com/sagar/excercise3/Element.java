package com.sagar.excercise3;

import java.util.ArrayList;

// Element interface
interface Element {
    void accept(Visitor visitor);
}
// Concrete element
class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);


    }
}

// Concrete element
class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitConcreteElementB(this);
    }
}
// Visitor interface
interface Visitor {
    void visitConcreteElementA(ConcreteElementA elementA);
    void visitConcreteElementB(ConcreteElementB elementB);
}
// Concrete visitor
class ConcreteVisitor implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA elementA) {
        System.out.println("Visited ConcreteElementA");
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB elementB) {
        System.out.println("Visited ConcreteElementB");
    }
}
