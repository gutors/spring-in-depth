package com.gutors.lil.fid.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gutors.lil.fid.aspect.Countable;

@Service
public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;

    @Value("${app.name}")
    private String name;

    // Dont need to use @Autowired because this is the only constructor 
    // and Spring will automatically use it to inject dependencies
    public OutputService(GreetingService greetingService, 
        TimeService timeService){
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    @Countable
    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }

}