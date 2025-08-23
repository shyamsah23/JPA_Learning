package com.Learner.hospitalManagement.controller;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldJobTriggerConroller {


    @Autowired
    public Scheduler scheduler;
    
    @GetMapping("/triggerJob/{jobName}")
    public String triggerHelloWorldJob(@PathVariable String jobName)  {

        JobKey jobKey = new JobKey(jobName);
        try {
            scheduler.triggerJob(jobKey);
            return "Job Triggered Succesfully";
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
