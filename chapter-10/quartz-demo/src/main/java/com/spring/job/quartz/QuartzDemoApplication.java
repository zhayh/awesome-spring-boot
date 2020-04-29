package com.spring.job.quartz;

import com.spring.job.quartz.scheduler.CronScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class QuartzDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(QuartzDemoApplication.class, args);
    }

    // 启动时触发
    @Autowired
    private CronScheduler cronScheduler;

    @Override
    public void run(String... args) throws Exception {
        cronScheduler.scheduleJobs();
    }
}
