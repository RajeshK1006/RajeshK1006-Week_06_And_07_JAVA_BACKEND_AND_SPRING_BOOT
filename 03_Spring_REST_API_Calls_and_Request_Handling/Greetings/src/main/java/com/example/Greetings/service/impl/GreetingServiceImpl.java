package com.example.Greetings.service.impl;

import com.example.Greetings.model.Greeting;
import com.example.Greetings.repository.GreetingRepository;
import com.example.Greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GreetingServiceImpl  implements GreetingService {
    @Override
    public String getSimpleGreeting(){
        return "Hello World!! this is an interface extended simple greeting message!!!!";
    }

    @Autowired
    private GreetingRepository gp;

    @Override
    public Greeting saveGreeting(String message){
        return gp.save(new Greeting(null,message));
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return gp.findById(id).orElse(null);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return gp.findAll();
    }

    @Override
    public Greeting updateGreeting(Long id, String newMessage) {
        Greeting g  = getGreetingById(id);
        g.setMessage(newMessage);
        return gp.save(g);
    }

    @Override
    public void deleteGreeting(Long id) {
        gp.deleteById(id);
    }



}
