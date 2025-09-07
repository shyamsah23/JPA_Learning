package com.Learner.hospitalManagement.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTime {
    private static final Logger logger = LoggerFactory.getLogger(ExecutionTime.class);

    @Around("@annotation(com.Learner.hospitalManagement.customAnnotation.TrackTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        logger.info("Method {} executed n {} ms", proceedingJoinPoint.getSignature(), (end - start));
        return result;
    }
}
