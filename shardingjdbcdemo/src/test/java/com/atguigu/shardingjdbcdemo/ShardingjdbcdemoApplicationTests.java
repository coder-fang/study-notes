package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.entity.Udict;
import com.atguigu.shardingjdbcdemo.entity.User;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.atguigu.shardingjdbcdemo.mapper.UdictMapper;
import com.atguigu.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class ShardingjdbcdemoApplicationTests {

    //注入Mapper
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;
    //=============================测试公共表============================
    //添加操作
    @Test
    public void addDict(){
        Udict udict = new Udict();
        udict.setUstatus("a");
        udict.setUvalue("已启用");
        udictMapper.insert(udict);
    }
    //删除操作
    @Test
    public void deleteDict(){
        QueryWrapper<Udict> wrapper = new QueryWrapper<>();
        wrapper.eq("dictid",668931093130379265L);
        udictMapper.delete(wrapper);
    }
    //==========================测试垂直分库==============================
    //添加操作
    @Test
    public void addUserDb() {
        User user = new User();
        user.setUsername("lucymarry");
        user.setUstatus("abc123");
        userMapper.insert(user);
    }

    //查询操作
    @Test
    public void findUserDb() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 670649749128347649L);
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    //===========================测试水平分库==========================
    //添加课程
    @Test
    public void addCourseDb() {
        Course course = new Course();
        course.setCname("java demo");
        //分库根据 user_id
        course.setUserId(111L);
        course.setCstatus("Normal1");
        courseMapper.insert(course);
    }

    //查询课程
    @Test
    public void findCourseDb() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", 100L);
        wrapper.eq("cid", 668899779312353281L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }

    //=========================测试水平分表============================
    //添加课程
    @Test
    public void addCourse() {
        for (int i = 1; i <= 10; i++) {
            Course course = new Course();
            course.setCname("java" + i);
            course.setUserId(100L);
            course.setCstatus("Normal" + i);
            courseMapper.insert(course);
        }
    }

    //查询课程
    @Test
    public void findCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 668871273614409728L);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }
}

