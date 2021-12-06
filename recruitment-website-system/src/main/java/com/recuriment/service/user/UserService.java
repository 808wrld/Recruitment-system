package com.recuriment.service.user;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.common.enums.ExceptionEnum;
import com.recuriment.domain.dto.user.UserCompanyManagerDto;
import com.recuriment.domain.dto.user.UserDto;
import com.recuriment.domain.dto.user.UserJoberDto;
import com.recuriment.domain.pojo.user.User;
import com.recuriment.domain.pojo.user.UserInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.user.LoginVo;
import com.recuriment.mapper.user.UserInfoMapper;
import com.recuriment.mapper.user.UserMapper;
import com.recuriment.utils.Subject;
import com.recuriment.utils.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关
 *
 * @Author lqp
 * @Date
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    public PublicRes login(LoginVo loginVo) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, loginVo.getUsername()).eq(User::getPassword, loginVo.getPassword()));
        if(user != null) {
            if(user.getRoleId().equals(loginVo.getRoleId())) {
                // 登录成功
                return PublicRes.OK(Dict.create().set("token", UserTokenManager.generateToken(user.getId())));
            } else {
                // 角色不符
                return PublicRes.Error(ExceptionEnum.AUTHENTICATION_ERROR_ACCOUNT_FREEZED);
            }
        } else {
            // 用户名密码错误
            return PublicRes.Error(ExceptionEnum.AUTHENTICATION_ERROR_PASSWORD_NOT_MATCH);
        }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    public PublicRes register(User user) {
        User user1 = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()));
        if(user1 != null) {
            return PublicRes.Error(ExceptionEnum.USER_ADD_ERROR_EXISTS);
        } else {
            userMapper.insert(user);
            return PublicRes.OK();
        }
    }

    /**
     * 用户详情(基础版)
     * @return
     */
    public UserDto getUser() {
        UserDto userDto = BeanUtil.toBeanIgnoreError(Subject.getUser(), UserDto.class);
        return userDto;
    }

    /**
     * 求职用户信息
     * @return
     */
    public UserInfo getUserDetail() {
        int userId = Subject.getUserId();
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, userId));
        return userInfo;
    }

    /**
     * 添加
     * @param userInfo
     * @return
     */
    public PublicRes addUserDetail(UserInfo userInfo) {
        UserInfo userInfo1 = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserId, Subject.getUserId()));
        if(userInfo1 != null) {
            userInfoMapper.deleteById(userInfo1);
        }
        userInfo.setUserId(Subject.getUserId());
        userInfoMapper.insert(userInfo);
        return PublicRes.OK();
    }

    /**
     * 更新
     * @return
     */
    public PublicRes updateUserDetail(UserInfo userInfo) {
        userInfoMapper.updateById(userInfo);
        return PublicRes.OK();
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    public PublicRes updateUserPassword(User user) {
        user.setId(Subject.getUserId());
        userMapper.updateById(user);
        return PublicRes.OK();
    }

    /**
     *
     * @return
     */
    public List<UserJoberDto> getUserJober() {
       return userMapper.getUserJober();
    }

    /**
     *
     * @return
     */
    public List<UserCompanyManagerDto> getUserCompanyManager() {
        return userMapper.getUserCompanyManager();
    }

    public void deleteByUid(Integer id) {
        userMapper.deleteById(id);
    }

}
