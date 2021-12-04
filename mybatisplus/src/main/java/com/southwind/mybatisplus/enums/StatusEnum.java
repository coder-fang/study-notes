package com.southwind.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * Create By  on 2021/4/22.
 */
public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息");

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue
    private Integer code;
    private String msg;
}
