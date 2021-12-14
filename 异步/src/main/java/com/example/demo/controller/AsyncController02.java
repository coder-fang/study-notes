package com.example.demo.controller;

import com.example.demo.service.DeferredResultQueue;
import com.example.demo.service.LongTermTaskCallback;
import com.example.demo.service.LongTimeAsyncCallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/14 17:18
 * 异步模式  返回DeferredResult<ModelAndView>
 */
@Controller
public class AsyncController02 {
    @Resource
    private LongTimeAsyncCallService longTimeAsyncCallService;

    @GetMapping("/asynctask")
    public DeferredResult<ModelAndView> asyncTask() {
        DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();
        System.out.println("/asynctask调用 ！thread id is : " + Thread.currentThread().getId());
        longTimeAsyncCallService.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
            @Override
            public void callback(Object result) {
                System.out.println("异步调用执行完成 thread id is:" + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView();
                mav.addObject("result", result);
                deferredResult.setResult(mav);
            }
        });

        //异步请求超时时调用
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                System.out.println("异步调用执行超时！ thread id is:" + Thread.currentThread().getId());
                ModelAndView modelAndView = new ModelAndView("remotecalltask");
                modelAndView.addObject("result", "异步调用执行超时");
                deferredResult.setResult(modelAndView);
            }
        });
        //异步请求完成时调用
        deferredResult.onCompletion(() -> {
            System.out.println(LocalDateTime.now().toString() + "--->onCompletion");
        });
        System.out.println(LocalDateTime.now().toString() + "--->主线程(" +
                Thread.currentThread().getName() + ")结束");
        return deferredResult;
    }
}
