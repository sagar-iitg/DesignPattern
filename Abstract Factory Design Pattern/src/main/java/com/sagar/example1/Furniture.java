package com.sagar.example1;

/**
 * Hello world!
 *
 */
public class Furniture
{
    public static void main( String[] args )
    {

        FurnitureFactory modernFactory = FurnitureFactory.createFurnitureFactory("modern");
        // use the abstract factory to create factories

        // Create Modern furniture items
        assert modernFactory != null;
        Sofa modernSofa = modernFactory.createSofa();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();

        // Use Modern furniture items
        modernSofa.sitOn();
        modernChair.sitOn();
        modernTable.place();



    }
}
