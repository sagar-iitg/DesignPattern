package com.sagar.logger.impl;

import com.sagar.logger.Logger;


public class InfoLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("INFO"+ msg);

    }
}
