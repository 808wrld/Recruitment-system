package com.recuriment.controller.user;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.common.constant.CommonConst;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author lqp
 * @Date 2021/11/4 15:13
 **/
@RestController
@CrossOrigin
public class UploadController {

    @Autowired
    FastFileStorageClient storageClient;

    @Autowired
    UserService userService;

    public static final String uploadUrlHead = "http://101.35.116.44:8888/";

    @UserLoginToken
    @PostMapping("upload")
    public PublicRes uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String ext = name.split("\\.")[1];
        StorePath storePath = storageClient.uploadFile(file.getBytes(), ext);
        String path = CommonConst.uploadUrlHead + storePath.getFullPath();
        return PublicRes.OK(path);
    }
}
