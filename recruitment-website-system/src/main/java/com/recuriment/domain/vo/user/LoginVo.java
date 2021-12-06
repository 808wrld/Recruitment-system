package com.recuriment.domain.vo.user;

import lombok.Data;

/**
 * @Author lqp
 * @Date 2021/11/4 9:52
 **/
@Data
public class LoginVo {

    private String username;

    private String password;

    private Integer roleId;
}
