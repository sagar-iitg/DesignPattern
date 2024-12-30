package com.sagar.example1.logger;

import com.sagar.example1.logger.impl.DebugLogger;
import com.sagar.example1.logger.impl.ErrorLogger;
import com.sagar.example1.logger.impl.InfoLogger;

public class LoggerFactory {

    public static Logger createLogger(LogLevel logLevel){


        return switch (logLevel) {
            case DEBUG -> new DebugLogger();
            case INFO -> new InfoLogger();
            case ERROR -> new ErrorLogger();
            default -> null;
        };



    }
}
