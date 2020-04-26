package com.spring.job.quartz.listener;

import com.spring.job.quartz.scheduler.CronScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-26 08:35
 * @description : 特定时间触发定时任务
 */

@Configuration
@EnableScheduling
@Component
public class SchedulerListener {
    @Autowired
    private CronScheduler scheduler;

    @Scheduled(cron = "0 15 9 * * ?")
    public void schedule() throws SchedulerException {
        scheduler.scheduleJobs();
    }
}
