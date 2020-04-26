package com.spring.job.quartz.job;

import com.spring.job.quartz.service.DemoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author : zhayh
 * @date : 2020-4-25 20:35
 * @description :
 */

@Setter
@Slf4j
public class SampleJob extends QuartzJobBean {
    private String name;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        log.info("正在执行 {} 任务，时间为 {}", this.name, LocalTime.now().withNano(0));
    }
}

