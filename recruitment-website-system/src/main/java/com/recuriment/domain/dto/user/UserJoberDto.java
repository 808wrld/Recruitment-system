package com.recuriment.domain.dto.user;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * @Author lqp
 * @Date 2021/11/6 15:54
 **/
@Data
public class UserJoberDto {

    private Integer id;

    private String username;

    private String sex;

    private Date birthday;

    private String realName;

    private String education;

    private String mobile;

    public Integer getAge() {

        if(birthday != null) {
            return DateUtil.age(birthday, new Date());
        }
        return null;
    }
}
