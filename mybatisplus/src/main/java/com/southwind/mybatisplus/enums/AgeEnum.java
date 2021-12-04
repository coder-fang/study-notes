package com.southwind.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

/**
 * Create By  on 2021/4/23.
 */
public enum AgeEnum implements IEnum<Integer> {
    ONE(1,"21岁"),TWO(2,"两岁"),THREE(3,"三岁");

    AgeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }
}
