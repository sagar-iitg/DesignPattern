package com.sagar.example1;

import com.sagar.example1.logger.LogLevel;
import com.sagar.example1.logger.Logger;
import com.sagar.example1.logger.LoggerFactory;

public class Main
{
    public static void main( String[] args )
    {
        Logger logger = LoggerFactory.createLogger(LogLevel.ERROR);
        logger.log(" This is Error");

    }




}
