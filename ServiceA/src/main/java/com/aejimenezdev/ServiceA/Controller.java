package com.aejimenezdev.ServiceA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }
}
