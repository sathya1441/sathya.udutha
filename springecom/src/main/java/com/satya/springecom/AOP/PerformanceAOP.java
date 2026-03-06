package com.satya.springecom.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAOP {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceAOP.class);

    @Around("execution(* com.satya.springecom.Controller.ProductController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint jp){
        long start = System.currentTimeMillis();
        Object proceed = null;
        try {
            proceed = jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("Execution time of " + jp.getSignature().getName() + " is " + (end - start) + " ms");
        return proceed;
    }
}