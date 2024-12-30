package com.sagar.example1.logger.impl;

import com.sagar.example1.logger.Logger;

public class DebugLogger implements Logger {

    @Override
    public void log(String msg) {
        System.out.println("DEBUG: " + msg);
    }

}
