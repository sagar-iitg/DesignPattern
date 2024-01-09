package com.sagar.example1;


// Abstract Factory: Furniture Factory
interface FurnitureFactory {
    Sofa createSofa();
    Chair createChair();
    Table createTable();

    public static FurnitureFactory createFurnitureFactory(String type) {
        if (type.equals("modern")) {
            return new ModernFurnitureFactory();
        } else if (type.equals("traditional")) {
            return new TraditionalFurnitureFactory();
        } else {
            return null;
        }
    }
}

// Concrete Factory: Modern Furniture Factory
class ModernFurnitureFactory implements FurnitureFactory {
    public Sofa createSofa() {
        return new ModernSofa();
    }

    public Chair createChair() {
        return new ModernChair();
    }

    public Table createTable() {
        return new ModernTable();
    }
}

// Concrete Factory: Traditional Furniture Factory
class TraditionalFurnitureFactory implements FurnitureFactory {
    public Sofa createSofa() {
        return new TraditionalSofa();
    }

    public Chair createChair() {
        return new TraditionalChair();
    }

    public Table createTable() {
        return new TraditionalTable();
    }
}