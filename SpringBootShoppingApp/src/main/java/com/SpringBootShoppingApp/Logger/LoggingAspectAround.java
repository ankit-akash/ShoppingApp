package com.SpringBootShoppingApp.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAround {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspectAround.class);

    @Around("execution(* com.SpringBootShoppingApp.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method execution start");
        Object result = joinPoint.proceed();
        logger.info("Method execution finish");
        return result;
    }
}
