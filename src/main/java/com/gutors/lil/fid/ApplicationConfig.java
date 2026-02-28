package com.gutors.lil.fid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import com.gutors.lil.fid.service.GreetingService;
import com.gutors.lil.fid.service.OutputService;
import com.gutors.lil.fid.service.TimeService;

public class ApplicationConfig {
    
    @Value("Hello")
    String greetingMessage;

    @Bean
    public TimeService timeService() {
        return new TimeService(true);
    }

    @Bean
    public OutputService outputService(GreetingService greetingService, TimeService timeService) {
        return new OutputService(greetingService, timeService);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greetingMessage);
    }

}
