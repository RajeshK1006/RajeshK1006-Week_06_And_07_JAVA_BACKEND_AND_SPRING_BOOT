package com.example.Greetings.controller;


import com.example.Greetings.model.Greeting;
import com.example.Greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @GetMapping
    public String getGreetings(){
        return "{\"message\" : \"Hello from GET method\"}";
    }

    @PostMapping
    public String postGreeting(){
        return "{\"message\" : \"Hello from the POST method\"}";
    }

    @PutMapping
    public String putGreeting(){
        return "{\"message\":\"Hello from the PUT method\"}";
    }

    @DeleteMapping
    public String deleteMapping(){
        return "{\"message\":\"Hello from the DELETE method\"}";
    }


    @Autowired
    private GreetingService greetingService;


    @GetMapping("/simple")
    public String getSimpleGreeting(){
        return greetingService.getSimpleGreeting();
    }


    @GetMapping("/custom")
    public String getCustomGreeting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        if (firstName != null && lastName != null)
            return "Hello " + firstName + " " + lastName;
        else if (firstName != null)
            return "Hello " + firstName;
        else if (lastName != null)
            return "Hello " + lastName;
        else
            return "Hello World";
    }


    @PostMapping("/service/save")
    public Greeting saveGreeting(@RequestParam Map<String, String> body){
        return greetingService.saveGreeting(body.get("message"));
    }


    @GetMapping("/service/{id}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable Long id){
        Greeting got = greetingService.getGreetingById(id);
        if(got==null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(got);
    }

    @GetMapping("/service/all")
    public List<Greeting> getAll(){
        return greetingService.getAllGreetings();
    }


    @PutMapping("/service/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Map<String, String> body){
        return greetingService.updateGreeting(id, body.get("message"));
    }

    @DeleteMapping("/service/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }

}

