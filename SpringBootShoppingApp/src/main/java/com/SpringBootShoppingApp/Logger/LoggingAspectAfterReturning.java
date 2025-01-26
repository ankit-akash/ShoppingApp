package com.SpringBootShoppingApp.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfterReturning {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAfterReturning.class);

    @Pointcut("execution(* com.SpringBootShoppingApp.service.*.*(..))")
    public void selectAll() {}

    @AfterReturning(pointcut = "selectAll()", returning = "result")
    public void logAfterReturning(Object result) {
        logger.info("Method returned value is: " + result);
    }
}
