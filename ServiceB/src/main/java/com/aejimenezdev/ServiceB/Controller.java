package com.aejimenezdev.ServiceB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/serviceB")
public class Controller {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World from Service B!";
    }
}
