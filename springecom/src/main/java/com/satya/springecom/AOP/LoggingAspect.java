package com.satya.springecom.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.satya.springecom.Controller.ProductController.*(..)) || execution(* com.satya.springecom.Controller.OrderController.*(..))")
    public void logInfo(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + " method called from " + jp.getTarget().getClass().getSimpleName());
    }

    @AfterReturning(pointcut = "execution(* com.satya.springecom.Controller.ProductController.*(..)) || execution(* com.satya.springecom.Controller.OrderController.*(..))")
    public void logAfterReturning(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + " method completed successfully");
    }

    @AfterThrowing(pointcut = "execution(* com.satya.springecom.Controller.ProductController.*(..)) || execution(* com.satya.springecom.Controller.OrderController.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint jp, Exception exception) {
        logger.error(jp.getSignature().getName() + " method threw an exception: " + exception.getMessage());
    }
}