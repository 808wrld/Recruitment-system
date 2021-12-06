package com.recuriment.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.domain.pojo.user.UserComplain;
import com.recuriment.mapper.user.UserComplainMapper;
import com.recuriment.utils.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lqp
 * @Date
 **/
@Service
public class UserComplainService {

    @Autowired
    UserComplainMapper userComplainMapper;

    /**
     * 投诉列表
     * @return
     */
    public List<UserComplain> getUserComplainList() {
        List<UserComplain> userComplains = userComplainMapper.getList();
        return userComplains;
    }

    /**
     * 添加投诉
     * @return
     */
    public int addUserComplain(UserComplain userComplain) {
        userComplain.setUserId(Subject.getUserId());
        return userComplainMapper.insert(userComplain);
    }


    /**
     * 删除投诉
     * @param id
     */
    public void deleteUserComplain(Integer id) {
        userComplainMapper.deleteById(id);
    }

}
