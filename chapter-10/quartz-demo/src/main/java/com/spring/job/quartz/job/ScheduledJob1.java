package com.spring.job.quartz.job;

import com.spring.job.quartz.service.DemoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhayh
 * @date : 2020-4-26 08:21
 * @description :
 */

@Slf4j
public class ScheduledJob1 implements Job {
    @Autowired
    DemoService demoService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Scheduled job1 运行, demoService 为： {} ......", demoService);
    }
}
