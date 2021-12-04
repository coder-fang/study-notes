package com.southwind.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.southwind.mybatisplus.enums.AgeEnum;
import com.southwind.mybatisplus.enums.StatusEnum;
import lombok.Data;
import java.util.Date;

@Data
@TableName(value = "user")
public class User {
    //设置为默认（数据库自增），雪花算法
    @TableId
    private Integer id;
    @TableField(value = "name",select = false)
    private String title;
    private Integer age;
    @TableField(exist = false)
    private String gender;
//    private Product product;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version //乐观锁标记
    private Integer version;
    private StatusEnum status;
    private AgeEnum ageEnum;
//    @TableLogic
    private Integer deleted;
}
