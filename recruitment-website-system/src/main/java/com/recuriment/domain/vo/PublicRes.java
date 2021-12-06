package com.recuriment.domain.vo;

import com.recuriment.common.enums.ExceptionEnum;
import com.recuriment.exception.BusinessException;
import lombok.Data;

/**
 * @Author lqp
 * @Date 2020/10/19 10:38
 **/
@Data
public class PublicRes<T> {

    private int code = 0;
    private String msg = "";
    private T result;

    public PublicRes(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public PublicRes(T result) {
        super();
        this.result = result;
    }

    public PublicRes() {
        super();
    }

    public void setPr(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setError(BusinessException e){
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public void setError(ExceptionEnum e){
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public void setQuerySuccess(T result)  {
        this.code = 0;
        this.msg = "查询成功";
        this.result = result;
    }

    public static PublicRes Error(BusinessException e) {
        PublicRes publicRes = new PublicRes();
        publicRes.setError(e);
        return publicRes;
    }

    public static PublicRes Error(ExceptionEnum e) {
        PublicRes publicRes = new PublicRes();
        publicRes.setError(e);
        return publicRes;
    }

    public static PublicRes OK() {
        return new PublicRes(0, "操作成功");
    }

    public static PublicRes OK(Object result) {
        PublicRes publicRes = new PublicRes(0, "操作成功");
        publicRes.setResult(result);
        return publicRes;}
}
