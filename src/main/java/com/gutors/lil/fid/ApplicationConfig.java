package com.gutors.lil.fid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.gutors.lil.fid.service.GreetingService;
import com.gutors.lil.fid.service.OutputService;
import com.gutors.lil.fid.service.TimeService;

@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    
    @Value("${app.greeting}")
    private String greetingMessage;

    @Value("${app.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24;

    @Bean
    public TimeService timeService() {
        return new TimeService(is24);
    }

    @Bean
    public OutputService outputService(GreetingService greetingService, TimeService timeService) {
        return new OutputService(greetingService, timeService, name);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greetingMessage);
    }

}
