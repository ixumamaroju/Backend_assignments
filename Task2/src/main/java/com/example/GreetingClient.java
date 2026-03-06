package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingClient {
    private final GreetingService greetingService;
    @Autowired
    public GreetingClient(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    public void showGreeting(){
        System.out.println(greetingService.greet("Uma"));
    }
}
