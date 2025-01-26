package com.SpringBootShoppingApp.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectBefore {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectBefore.class);

    @Before("execution(* com.SpringBootShoppingApp.service.*.*(..))")
    public void logBefore() {
        logger.info("Before method execution");
    }
}
