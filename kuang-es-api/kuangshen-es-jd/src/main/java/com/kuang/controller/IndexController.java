package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/16 10:45
 */
@Controller
public class IndexController {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
