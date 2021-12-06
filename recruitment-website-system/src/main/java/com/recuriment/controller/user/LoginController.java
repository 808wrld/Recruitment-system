package com.recuriment.controller.user;

import com.recuriment.domain.pojo.user.User;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.domain.vo.user.LoginVo;
import com.recuriment.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 *
 * @author
 * @module
 * @date 2021/11/4 9:01
 * @copyright
 */
@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param loginVo
     * @return
     */
    @PostMapping("login")
    public PublicRes login(@RequestBody LoginVo loginVo) {
        return userService.login(loginVo);
    }


    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("register")
    public PublicRes login(@RequestBody User user) {
        return userService.register(user);
    }
}
