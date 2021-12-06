package com.recuriment.domain.vo;

import lombok.Data;

/**
 * @Author lqp
 * @Date 2020/10/26 14:44
 **/
@Data
public class BasePageReq {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
