package com.example.demo.controller;

import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/14 15:33
 */
@RequestMapping("/async")
@RestController
public class AsyncController {
    @ResponseBody
    @RequestMapping("/hello")
    public Callable<String> async01() {
        System.out.println("主线程开始..." + Thread.currentThread().getName() + "===>" + System.currentTimeMillis());
        //实现接口 ----> 函数式编程
        Callable<String> callable = () -> {
            System.out.println("副线程开始..." + Thread.currentThread().getName() + "===>" + System.currentTimeMillis());
            //模拟处理业务逻辑 花费了5秒钟   相当于 TimeUnit.SECONDS.sleep(5);
            Thread.sleep(5000);
            System.out.println("副线程结束..." + Thread.currentThread().getName() + "===>" + System.currentTimeMillis());
            //最终返回的不是Callable对象，而是里面的内容
            return "hello world";
        };
        System.out.println("主线程结束..." + Thread.currentThread().getName() + "===>" + System.currentTimeMillis());
        return callable;
    }
}
