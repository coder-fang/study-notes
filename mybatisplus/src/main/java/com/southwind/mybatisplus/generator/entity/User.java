package com.southwind.mybatisplus.generator.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2021-05-01
 */
@Data
public class User  {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer version;

    private Integer status;

    private Integer ageEnum;

    private Integer deleted;


}
