package com.SpringBootShoppingApp.Logger;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfterThrowing {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAfterThrowing.class);

    @Pointcut("execution(* com.SpringBootShoppingApp.service.*.*(..))")
    public void selectAll() {}

    @AfterThrowing(pointcut = "selectAll()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        logger.error("Exception: " + exception.getMessage());
    }
}
