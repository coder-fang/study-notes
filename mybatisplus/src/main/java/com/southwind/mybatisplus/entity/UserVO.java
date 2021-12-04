package com.southwind.mybatisplus.entity;

import lombok.Data;

/**
 * Create By  on 2021/4/20.
 * 把前端需要的实体类的属性拿出来做二次封装
 */
@Data
public class UserVO {
    private Long userId;
    private String productName;
    private String userName;
    private Integer age;



}
