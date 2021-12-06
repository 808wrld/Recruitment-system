package com.recuriment.mapper.user;

import com.recuriment.domain.pojo.user.UserComplain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 投诉(user_complain)数据Mapper
 *
 * @author 
 * @since 2021-11-06 19:01:41
 * @description 
*/
public interface UserComplainMapper extends BaseMapper<UserComplain> {

    List<UserComplain> getList();
}
