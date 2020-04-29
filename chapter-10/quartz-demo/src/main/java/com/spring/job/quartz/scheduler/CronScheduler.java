package com.spring.job.quartz.scheduler;

import com.spring.job.quartz.job.ScheduledJob1;
import com.spring.job.quartz.job.ScheduledJob2;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-26 08:23
 * @description :
 */

@Component
public class CronScheduler {
    @Autowired
    private SchedulerFactoryBean factoryBean;

    // 使用 Scheduler启动两个定时任务
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = factoryBean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        // 1. 创建 JobDetail对象
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob1.class)
                .withIdentity("CronJob1", "CronGroup1")
                .build();

        // 2. 创建 基于 Quartz Cron 表达式的调度计划的构造器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/6 * * * * ?");

        // 3. 创建 Trigger触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("CronTrigger1", "CronGroup1")  // 设置触发器和触发器组的名称
                .withSchedule(scheduleBuilder)
                .build();

        // 4. 注册 JobDetail和 Trigger到 Scheduler调度器
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException {
        // 1. 创建 JobDetail对象
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob2.class)
                .withIdentity("CronJob2", "CronGroup2").build();

        // 2. 基于 Quartz Cron 表达式的调度计划的构造器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/12 * * * * ?");

        // 3. 创建 Trigger触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("CronTrigger2", "CronGroup2")
                .withSchedule(scheduleBuilder).build();

        // 4. 注册 JobDetail和 Trigger到 Scheduler调度器
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
