package com.sagar.example1;

// Concrete Products: Modern Furniture Items
class ModernSofa implements Sofa {
    public void sitOn() {
        System.out.println("Sitting on a Modern Sofa");
    }
}

class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a Modern Chair");
    }
}
class ModernTable implements Table {
    public void place() {
        System.out.println("Placing items on a Modern Table");
    }
}


// Concrete Products: Traditional Furniture Items
class TraditionalSofa implements Sofa {
    public void sitOn() {
        System.out.println("Sitting on a Traditional Sofa");
    }
}

class TraditionalChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on a Traditional Chair");
    }
}


class TraditionalTable implements Table {
    public void place() {
        System.out.println("Placing items on a Traditional Table");
    }
}
