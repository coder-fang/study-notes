package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiFang
 * @version 1.0
 * @since 2022/1/10 10:47
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
