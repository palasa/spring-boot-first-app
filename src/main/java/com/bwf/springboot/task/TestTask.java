package com.bwf.springboot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

// @Component
public class TestTask {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private static Logger logger = LoggerFactory.getLogger( TestTask.class );

    // 每三秒自动执行
    // cron 表达式      cron.qqe2.com
    // @Scheduled( fixedRate = 3000)
    @Scheduled(cron = "10-50 * * * * ?")
    public void reportCurrentTime(){
        logger.error("Test Task , 现在的时间是：{}" , sdf.format(new Date()));
    }
}
