package com.recuriment.exception;

import com.recuriment.common.enums.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常的封装
 *
 * @author
 * @date 2020年10月22日 19:33:19
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class BusinessException extends RuntimeException {

    /**
     * code码
     */
    private int code;

    /**
     * 友好提示
     */
    private String message;


    public BusinessException(int code , String message) {
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message) {
        this.code = ExceptionEnum.ERROR_CUSTOMIZE_ERROR.getCode();
        this.message = message;
    }

    public BusinessException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

}
