package com.aejimenezdev.ServiceB;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class Controller {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public Controller(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
        restClient = RestClient.create();
    }

    @GetMapping
    public String helloWorld() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("ServiceA").get(0);
        String url = serviceInstance.getUri().toString() + "/helloWorld";

        String response = restClient.get().uri(url).retrieve().body(String.class);
        return response;
    }
}
