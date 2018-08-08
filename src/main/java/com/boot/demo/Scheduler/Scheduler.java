package com.boot.demo.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时器类
 *
 * @author cui
 * @create 2018-08-07 15:33
 **/
public class Scheduler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    public void statusCheck() {
        logger.info("每分钟执行一次。开始……");
        //statusTask.healthCheck();

        logger.info("每分钟执行一次。结束。");
    }

    @Scheduled(fixedRate=20000)
    public void testTasks() {
        logger.info("每20秒执行一次。开始……");
        //statusTask.healthCheck();
        logger.info("每20秒执行一次。结束。");
    }
}
