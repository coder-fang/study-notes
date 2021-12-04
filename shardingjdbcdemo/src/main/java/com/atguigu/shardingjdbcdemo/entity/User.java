package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/20 20:27
 */
@Data
@TableName(value = "t_user")
public class User {
    private Long userId;
    private String username;
    private String ustatus;
}
