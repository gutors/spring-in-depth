package com.gutors.lil.fid;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gutors.lil.fid.service.OutputService;

public class Application {

    public static void main(String[] args) throws Exception {
        // Manual instantiation without Spring
        // GreetingService greetingService = new GreetingService("Hello");
        // TimeService timeService = new TimeService(true);
        // OutputService outputService = new OutputService(greetingService, timeService);

        // Using Spring to manage dependencies
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}