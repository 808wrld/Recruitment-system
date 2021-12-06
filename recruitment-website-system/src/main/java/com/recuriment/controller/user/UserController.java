package com.recuriment.controller.user;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.domain.pojo.user.User;
import com.recuriment.domain.pojo.user.UserInfo;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 *
 * @Author
 * @Date 2021/11/4 11:27
 **/
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户详情
     * @return
     */
    @UserLoginToken
    @GetMapping("info")
    public PublicRes getUserInfo() {
        return PublicRes.OK(userService.getUser());
    }

    /**
     * 用户详情
     * @return
     */
    @UserLoginToken
    @GetMapping("detail")
    public PublicRes getUserDetail() {
        return PublicRes.OK(userService.getUserDetail());
    }


    /**
     * 求职用户
     * @return
     */
    @UserLoginToken
    @GetMapping("byJober")
    public PublicRes getUserByJober() {
        return PublicRes.OK(userService.getUserJober());
    }

    /**
     * 企业用户
     * @return
     */
    @UserLoginToken
    @GetMapping("byCompany")
    public PublicRes getUserbyCompany() {
        return PublicRes.OK(userService.getUserCompanyManager());
    }

    /**
     * 用户详情-添加
     * @return
     */
    @UserLoginToken
    @PutMapping("detail")
    public PublicRes addUserDetail(@RequestBody UserInfo userInfo) {
        return userService.addUserDetail(userInfo);
    }


    /**
     * 用户详情-更新
     * @return
     */
    @UserLoginToken
    @PostMapping("detail")
    public PublicRes updateUserDetail(@RequestBody UserInfo userInfo) {
        return userService.updateUserDetail(userInfo);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @UserLoginToken
    @PostMapping("changePassword")
    public PublicRes updateUserPassword(@RequestBody User user) {
        return userService.updateUserPassword(user);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public PublicRes deleteUser(@PathVariable Integer id) {
        userService.deleteByUid(id);
        return PublicRes.OK();
    }
}
