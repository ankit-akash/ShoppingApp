package com.SpringBootShoppingApp.Logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAfter.class);

    @After("execution(* com.SpringBootShoppingApp.service.*.*(..))")
    public void logAfter() {
        logger.info("After method execution");
    }
}
