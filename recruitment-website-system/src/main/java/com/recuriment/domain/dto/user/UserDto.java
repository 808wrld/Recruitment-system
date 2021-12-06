package com.recuriment.domain.dto.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户
 *
 * @Author
 * @Date
 **/
@Data
public class UserDto {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 角色id 1-管理员,2-求职用户,3-企业
     */
    private Integer roleId;

}
