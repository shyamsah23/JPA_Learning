package com.Learner.hospitalManagement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuit/breaker")
public class CircuitBreakerDummyController {

    @GetMapping("/demo")
    public String dummyPatientController()
    {
        // Feign client Call to Other Service  ->  Treating this service as gateway later it can be modified
        return "OK";
    }

}
