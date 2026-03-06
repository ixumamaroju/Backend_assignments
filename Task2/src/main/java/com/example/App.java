package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        GreetingClient client = context.getBean(GreetingClient.class);
        client.showGreeting();
        context.close();

        System.out.println("---- Without Spring ----");
        GreetingService manualService = new GreetingService();
        GreetingClient manualClient = new GreetingClient(manualService);
        manualClient.showGreeting();
    }
}
