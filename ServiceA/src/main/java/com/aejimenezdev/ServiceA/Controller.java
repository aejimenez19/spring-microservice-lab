package com.aejimenezdev.ServiceA;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceA")
public class Controller {
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world from Service A!";
    }
}
