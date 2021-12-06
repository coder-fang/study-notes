package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/12/6 11:16
 * json封装体CommonResult,传给前端。判断响应码是否正确.成功才显示
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {   //泛型：如果装的payment.返回payment,装的order,返回order
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
