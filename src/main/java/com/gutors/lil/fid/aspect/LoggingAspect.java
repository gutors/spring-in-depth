package com.gutors.lil.fid.aspect;

import java.util.Arrays;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
    
    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
        // do nothing
    }

    // execute this before the main @Pointcut method
    @Before("executeLogging()")
    public void logMethodCall(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder("Method=");
        sb.append(joinPoint.getSignature().getName());
       
        Object[] args = joinPoint.getArgs();
        
        if (args != null && args.length > 0) {
            sb.append(" | args=[ ");
            Arrays.asList(args).forEach(arg -> {
                sb.append(arg).append(" | ");
            });
            sb.append("]");
        }
        
        LOGGER.info(sb.toString().replace("| ]", "]"));
    }

    // execute this after the main @Pointcut method and log the return value
    @AfterReturning(pointcut = "executeLogging()", returning = "returnValue")
    public void logMethodExecution(JoinPoint joinPoint, Object returnValue) {
        StringBuilder sb = new StringBuilder("Method=");
        sb.append(joinPoint.getSignature().getName());
       
        Object[] args = joinPoint.getArgs();
        
        if (args != null && args.length > 0) {
            sb.append(" | args=[ ");
            Arrays.asList(args).forEach(arg -> {
                sb.append(arg).append(" | ");
            });
            sb.append("]");
        }

        if (returnValue instanceof Collection) {
            sb.append(" returning: ").append(((Collection)returnValue).size()).append("instances");
        } else {
            sb.append(" returning: ").append(returnValue.toString());
        }

        LOGGER.info(sb.toString().replace("| ]", "]"));
    }

}
