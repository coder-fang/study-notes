package com.atguigu.shardingjdbcdemo.mapper;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author LiFang
 * @version 1.0
 * @since 2021/11/20 14:38
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

}
