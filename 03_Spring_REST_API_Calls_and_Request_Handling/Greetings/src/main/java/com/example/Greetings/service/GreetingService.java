package com.example.Greetings.service;

import com.example.Greetings.model.Greeting;

import java.util.List;

public interface GreetingService {
    String getSimpleGreeting();

    Greeting saveGreeting(String message);
    Greeting getGreetingById(Long id);
    List<Greeting> getAllGreetings();

    Greeting updateGreeting(Long id, String newMessage);


    void deleteGreeting(Long id);
}
