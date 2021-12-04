package com.atguigu.shardingjdbcdemo.mapper;

import com.atguigu.shardingjdbcdemo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/20 20:28
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
