package com.recuriment.controller.user;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.domain.pojo.user.UserComplain;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.user.UserComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 投诉
 *
 * @Author
 * @Date
 **/
@RestController
@CrossOrigin
@RequestMapping("userComplain")
public class UserComplainController {

    @Autowired
    UserComplainService userComplainService;


    /**
     * 获取投诉列表
     * @return
     */
    @GetMapping
    public PublicRes getList() {
        return PublicRes.OK(userComplainService.getUserComplainList());
    }

    /**
     * 添加投诉
     * @return
     */
    @UserLoginToken
    @PutMapping
    public PublicRes addUserComplain(@RequestBody UserComplain userComplain) {
        userComplainService.addUserComplain(userComplain);
        return PublicRes.OK();
    }

    /**
     * 删除投诉
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public PublicRes deleteUserComplain(@PathVariable Integer id) {
        userComplainService.deleteUserComplain(id);
        return PublicRes.OK();
    }
}
