package com.gutors.lil.fid.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CountingAspect {
    
    private static Map<String, Integer> methodCallCounts = new HashMap<>();
    private static Logger LOGGER = LoggerFactory.getLogger(CountingAspect.class);

    @Pointcut("@annotation(Countable)")
    public void executeCounting() {
        // do nothing
    }

    @Around("executeCounting()")
    public Object countMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        methodCallCounts.put(methodName, methodCallCounts.getOrDefault(methodName, 0) + 1);

        Object returnValue =  pjp.proceed();

        LOGGER.info("Method {} has been called {} times", methodName, methodCallCounts.get(methodName));

        return returnValue;
    }

}
