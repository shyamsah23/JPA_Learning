package com.Learner.hospitalManagement.config;


import com.Learner.hospitalManagement.jobs.HelloWorldJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Value("${helloWorld_Cron_Expression}")
    private String cronExpression;

    @Bean
    public JobDetail helloWorldJobDetail() {
        return JobBuilder.newJob(HelloWorldJob.class)
                .withIdentity("helloWorldJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger helloWorldJobTrigger() {
        return TriggerBuilder.newTrigger()
                .forJob(helloWorldJobDetail())
                .withIdentity("helloWorldJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
    }
}
