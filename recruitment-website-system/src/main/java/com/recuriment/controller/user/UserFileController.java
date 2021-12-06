package com.recuriment.controller.user;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.domain.pojo.user.UserFile;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.user.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author
 * @Date
 **/
@RestController
@CrossOrigin
@RequestMapping("userFile")
public class UserFileController {

    @Autowired
    UserFileService userFileService;

    /**
     * 获取文档列表
     * @return
     */
    @UserLoginToken
    @GetMapping
    public PublicRes getUserFile() {
        return PublicRes.OK(userFileService.getUserFileList());
    }

    /**
     * 添加文档列表
     * @param userFile
     * @return
     */
    @UserLoginToken
    @PutMapping
    public PublicRes updateUserFile(@RequestBody UserFile userFile) {
        return PublicRes.OK(userFileService.addUserFile(userFile));
    }

    /**
     * 删除文档列表
     * @param id
     * @return
     */
    @UserLoginToken
    @DeleteMapping("{id}")
    public PublicRes deleteUserFile(@PathVariable Integer id) {
        return PublicRes.OK(userFileService.deleteUserFile(id));
    }

}
