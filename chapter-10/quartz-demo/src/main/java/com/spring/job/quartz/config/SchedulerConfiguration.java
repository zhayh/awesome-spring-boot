package com.spring.job.quartz.config;

import com.spring.job.quartz.job.SampleJob;
import com.spring.job.quartz.job.ScheduledJob1;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2020-4-26 08:05
 * @description : JobDetail 与 Trigger 需要成对出现
 */

@Configuration
public class SchedulerConfiguration {
    public static class SimpleJobConfigure {
        // 创建任务实例
        @Bean
        public JobDetail sampleJobDetail() {
            return JobBuilder.newJob(SampleJob.class)
                    .withIdentity("sampleJob")
                    .usingJobData("name", "niit")  // 传递参数
                    .storeDurably()  // 没有 Trigger 关联的时候任务是否被保留，还没 Trigger指向它，需要设为 true ，
                    .build();
        }

        // 创建触发器
        @Bean
        public Trigger sampleJobTrigger() {
            // 简单的调度计划的构造器
            SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(2) // 频率
                    .repeatForever(); // 次数
            // Trigger 构造器
            return TriggerBuilder.newTrigger()
                    .forJob(sampleJobDetail()) // 设置 Job
                    .withIdentity("sampleTrigger") // 设置触发器名称
                    .withSchedule(builder) // 设置调度器
                    .build();
        }
    }
    public static class CronJobConfiguration {
        @Bean
        public JobDetail cronJob() {
            return JobBuilder.newJob(ScheduledJob1.class)
                    .withIdentity("cronJob", "group1")
                    .storeDurably()
                    .build();
        }

        @Bean
        public Trigger cronTrigger() {
            // 1. 创建 基于 Quartz Cron 表达式的调度计划的构造器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");

            // 2. 创建 Trigger触发器
            return TriggerBuilder.newTrigger()
                    .forJob(cronJob()) // 对应 Job 为 demoJob01
                    .withIdentity("trigger1", "group1")  // 设置触发器和触发器组的名称
                    .withSchedule(scheduleBuilder)
                    .build();
        }
    }
}
