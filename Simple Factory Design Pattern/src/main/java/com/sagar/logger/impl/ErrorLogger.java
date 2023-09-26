package com.sagar.logger.impl;

import com.sagar.logger.Logger;

public class ErrorLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("Error"+msg);
    }
}
