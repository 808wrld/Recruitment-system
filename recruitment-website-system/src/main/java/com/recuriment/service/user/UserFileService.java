package com.recuriment.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recuriment.domain.pojo.user.UserFile;
import com.recuriment.mapper.user.UserFileMapper;
import com.recuriment.utils.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lqp
 * @Date 2021/11/6 18:26
 **/
@Service
public class UserFileService {

    @Autowired
    UserFileMapper userFileMapper;

    /**
     * 获取文档列表
     * @return
     */
    public List<UserFile> getUserFileList() {
        return userFileMapper.selectList(new LambdaQueryWrapper<UserFile>().eq(UserFile::getUserId, Subject.getUserId()));
    }

    /**
     * 添加文档
     * @param userFile
     * @return
     */
    public int addUserFile(UserFile userFile) {
        userFile.setUserId(Subject.getUserId());
        return userFileMapper.insert(userFile);
    }

    /**
     * 删除文档
     * @param id
     * @return
     */
    public int deleteUserFile(Integer id) {
        return userFileMapper.deleteById(id);
    }
}
