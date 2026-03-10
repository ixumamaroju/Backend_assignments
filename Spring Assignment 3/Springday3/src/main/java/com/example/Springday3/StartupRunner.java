package com.example.Springday3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupRunner {
    @Value("${app.name}")
    private String appName;

    @Value("${app.welcome}")
    private String welcomeMessage;

    @PostConstruct
    public void printMessage() {
        System.out.println("Application Name"+appName);
        System.out.println("Message"+welcomeMessage);
    }
}
