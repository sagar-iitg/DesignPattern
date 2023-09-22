package com.sagar;

import com.sagar.logger.LogLevel;
import com.sagar.logger.Logger;
import com.sagar.logger.LoggerFactory;

public class Main
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.createLogger(LogLevel.DEBUG);
        logger.log("This is debug");

    }




}
