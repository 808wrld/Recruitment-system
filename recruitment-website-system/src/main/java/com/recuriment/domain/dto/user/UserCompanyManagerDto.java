package com.recuriment.domain.dto.user;

import lombok.Data;

/**
 * @Author lqp
 * @Date 2021/11/6 16:09
 **/
@Data
public class UserCompanyManagerDto {

    private Integer id;

    private String username;

    private String cName;

    private String cAddress;

    private String cType;

    private String cContact;
}
