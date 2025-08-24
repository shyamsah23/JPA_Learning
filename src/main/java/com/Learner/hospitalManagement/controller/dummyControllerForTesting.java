package com.Learner.hospitalManagement.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dummyControllerForTesting {

    @GetMapping("/dummy")
    public String dummyController(){
        return "Hello World";
    }
}
