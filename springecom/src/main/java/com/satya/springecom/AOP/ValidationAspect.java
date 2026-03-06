package com.satya.springecom.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.satya.springecom.Controller.ProductController.getSingleProduct(..))&& args(id)")
    public Object validateEndPoint(ProceedingJoinPoint jp,int id) throws Throwable {
        if (id <= 0) {
            logger.info("Invalid ID provided: " + id);
            id = -id;
        }
        return jp.proceed(new Object[]{id});
    }
}