package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/14 17:31
 * 模拟长时间异步调用 服务类
 */
@Service
public class LongTimeAsyncCallService {
    private final int CorePoolSize = 4;
    private final int NeedSeconds = 3;
    private Random random = new Random();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CorePoolSize);

    public void makeRemoteCallAndUnknownWhenFinish(LongTermTaskCallback callback) {
        System.out.println("完成此任务需要：" + NeedSeconds + "秒");
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                callback.callback("长时间异步调用完成。");
            }
        }, 3000, TimeUnit.SECONDS);
    }
}
