package com.spring.job.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author : zhayh
 * @date : 2020-4-26 08:21
 * @description :
 */

@Slf4j
public class ScheduledJob2 implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Scheduled job2 运行中......");
    }
}
