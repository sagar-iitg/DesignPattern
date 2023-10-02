package com.sagar;

import java.util.ArrayList;
import java.util.List;

// Aggregate class that stores products and provides an iterator
class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Iterator createIterator() {
        return new ProductIterator(products);
    }
}