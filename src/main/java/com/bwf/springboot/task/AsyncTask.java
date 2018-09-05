package com.bwf.springboot.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
// 异步注解 ，无此注解则该类中所有任务成为同步 任务
// 也可以作为 方法注解
@Async
public class AsyncTask {

    // private static Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    public Future<Boolean> doTask1() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务耗时：" + (end-start) + "毫秒");
        return new AsyncResult<>(true);
    }

    public Future<Boolean> doTask2() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务耗时：" + (end-start) + "毫秒");
        return new AsyncResult<>(true);
    }

    public Future<Boolean> doTask3() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务耗时：" + (end-start) + "毫秒");
        return new AsyncResult<>(true);
    }
}
