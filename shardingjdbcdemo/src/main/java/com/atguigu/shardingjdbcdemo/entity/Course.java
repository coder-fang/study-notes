package com.atguigu.shardingjdbcdemo.entity;

import lombok.Data;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/20 14:36
 */
@Data
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;
}
