package com.sagar.example1.logger.impl;

import com.sagar.example1.logger.Logger;

public class ErrorLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("Error"+msg);
    }
}
