package com.sagar.logger;

import com.sagar.logger.impl.DebugLogger;
import com.sagar.logger.impl.ErrorLogger;
import com.sagar.logger.impl.InfoLogger;

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
