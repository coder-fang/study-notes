package com.southwind.mybatisplus.generator.service.impl;

import com.southwind.mybatisplus.generator.entity.User;
import com.southwind.mybatisplus.generator.mapper.UserMapper;
import com.southwind.mybatisplus.generator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
