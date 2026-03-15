package com.gutors.lil.fid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages="com.gutors.lil.fid")
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class ApplicationConfig {
    // No need to define beans because they are annotated 
    // with @Service and we are using @ComponentScan to find them
}
