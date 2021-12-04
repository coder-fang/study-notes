package com.southwind.mybatisplus.mapper;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.mybatisplus.entity.User;
import com.southwind.mybatisplus.entity.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create By  on 2021/4/19.
 */
//启动整个ioc容器，就可以获取到里面各种各样的bean
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper mapper;
    @Test
    void test(){
        mapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setTitle("李宁");
        user.setAge(24);
//        mapper.insert(user);
        mapper.insert(user);
        System.out.println(user);
    }
    @Test
    void update(){
        User user = mapper.selectById(6);
        user.setTitle("小红");
        QueryWrapper wrapper= new QueryWrapper();
        wrapper.eq("age",21);
        mapper.update(user,wrapper);
    }
//    @Test
//    void delete(){
//        mapper.deleteById(1);
//    }
    @Test
    void select(){
//        //不加任何条件查询
//        //mapper.selectList(null);
//        //多条件查询
//        QueryWrapper wrapper = new QueryWrapper();
////        Map<String,Object> map = new HashMap<>();
////        map.put("name","张三");
////        map.put("age","21");
////        wrapper.allEq(map);
////        System.out.println(mapper.selectList(wrapper));
//        //lt 小于 ； gt 大于 ;ne 不等 ; ge 大于等于 ;  like 模糊查询（likeLeft "%小"、likeRight “小%”）
////        wrapper.gt("age",22);
////        wrapper.ne("age",22);
////inSQL 严格查询（嵌套查询）
////        wrapper.inSql("id","select id from user where id<25");
////        wrapper.inSql("id","select id from user where age>21");
//        //排序 orderBy...
//        wrapper.orderByAsc("age");
//
//        mapper.selectList(wrapper).forEach(System.out::println);
//        System.out.println(mapper.selectById(6));
//        mapper.selectBatchIds(Arrays.asList(6,1)).forEach(System.out::println);
//        //Map 只能做等值判断，逻辑判断用 Wrapper来处理
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",6);
//        mapper.selectByMap(map).forEach(System.out::println);

//        QueryWrapper wrapper =  new QueryWrapper();
//        wrapper.gt("id",6);
//        System.out.println(mapper.selectList(wrapper));

        //将查询的结果集封装到map中(以map集合形式返回)
//        mapper.selectMaps(wrapper).forEach(System.out::println);
//        System.out.println("--------------------");
//        //以对象返回
//        mapper.selectList(wrapper).forEach(System.out::println);
        //分页查询
//        IPage<User> page = new Page<>(1,2);
//        IPage<User> result = mapper.selectPage(page,null);
//        System.out.println(result.getSize());
//        System.out.println("888888888");
//        System.out.println(result.getTotal());
//       result.getRecords().forEach(System.out::println);
//        result.getRecords().forEach(System.out::println);

// or (class MyPage extends Ipage<UserVo>{ private Integer state; })

    }
    @Test
    void product(){
        mapper.productList(7).forEach(System.out::println);
    }
    @Test
    void delete(){
//        mapper.deleteBatchIds(Arrays.asList(7,8));
    }
}
