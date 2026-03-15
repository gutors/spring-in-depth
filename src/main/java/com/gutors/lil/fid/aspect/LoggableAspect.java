package com.gutors.lil.fid.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggableAspect {
    
    @Pointcut("@annotation(Loggable)")
    public void executeLogging() {
        // do nothing
    }
    
}
