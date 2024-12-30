package com.sagar;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Create a product

        Product product1=new Product("Laptop",100000);
        Product product2=new Product("Smartphone",30000);
        Product product3=new Product("Headphones",1200);
        Inventory inventory=new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        Iterator it=inventory.createIterator();
        Product currentProduct=it.first();
        System.out.println(currentProduct.getName()+"----"+currentProduct.getPrice());

        System.out.println("while loop started");
        while (currentProduct!=null)
        {
            System.out.println(currentProduct.getName()+" -- "+currentProduct.getPrice());
            currentProduct=it.next();
        }


    }
}