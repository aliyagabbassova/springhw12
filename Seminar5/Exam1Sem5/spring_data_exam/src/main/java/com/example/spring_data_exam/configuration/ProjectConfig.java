package com.example.spring_data_exam.configuration;

import com.example.spring_data_exam.aspects.UserActionAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public UserActionAspect loggingAspect() {return new UserActionAspect();}
}
