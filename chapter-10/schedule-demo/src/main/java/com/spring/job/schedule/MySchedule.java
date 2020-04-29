package com.spring.job.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : zhayh
 * @date : 2020-4-25 17:35
 * @description :
 */

@Slf4j
@Component
public class MySchedule {
    @Scheduled(fixedDelay = 2000)
    public void fixedDelay() {
        log.info("fixedDelay: {}", LocalTime.now().withNano(0));
    }

    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
        log.info("fixedRate: {}", LocalTime.now().withNano(0));
    }

    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void initialDelay() {
        log.info("initialDelay: {}", LocalTime.now().withNano(0));
    }

    @Scheduled(cron = "0 0/2 20 * * ?")
    public void cron() {
        log.info("cron: {}", LocalTime.now().withNano(0));
    }
}
