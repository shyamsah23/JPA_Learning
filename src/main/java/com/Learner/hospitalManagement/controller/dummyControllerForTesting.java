package com.Learner.hospitalManagement.controller;


import com.Learner.hospitalManagement.customAnnotation.TrackTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dummyControllerForTesting {
    @TrackTime
    @GetMapping("/dummy")
    public String dummyController() throws InterruptedException {
        Thread.sleep(4000);
        return "Hello World";
    }
}
