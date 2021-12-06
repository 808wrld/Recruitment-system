package com.recuriment.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.recuriment.domain.dto.user.UserCompanyManagerDto;
import com.recuriment.domain.dto.user.UserJoberDto;
import com.recuriment.domain.pojo.user.User;

import java.util.List;

/**
 * TODO
 * TODO
 *
 * @author
 * @module TODO
 * @date 2021/11/4 8:45
 * @copyright
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserJoberDto> getUserJober();


    List<UserCompanyManagerDto> getUserCompanyManager();


}
