package com.southwind.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.mybatisplus.entity.ProductVO;
import com.southwind.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT p.*,u.name userName FROM prodoct p,USER u WHERE p.user_id = u.id AND u.id = #{id}")
    List<ProductVO> productList(Integer id);
}

