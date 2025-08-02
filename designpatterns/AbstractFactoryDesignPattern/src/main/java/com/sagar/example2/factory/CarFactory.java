package com.sagar.example2.factory;

import com.sagar.example2.product.SUV;
import com.sagar.example2.product.Sedan;

public interface CarFactory {
    SUV createSUV();
    Sedan createSedan();
}