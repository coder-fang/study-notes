package com.southwind.mybatisplus.entity;

import lombok.Data;

/**
 * Create By  on 2021/5/1.
 */
@Data
public class ProductVO {
    private Integer category;
    private Integer count;
    private String description;
    private Integer userId;
    private String userName;
}
