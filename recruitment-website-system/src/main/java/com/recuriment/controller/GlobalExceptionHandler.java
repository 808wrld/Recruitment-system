package com.recuriment.controller;

import com.recuriment.common.enums.ExceptionEnum;
import com.recuriment.domain.vo.PublicRes;
import com.recuriment.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author
 * @Date
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public PublicRes businessExceptionHandler(BusinessException e) {
        return PublicRes.Error(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public PublicRes exceptionHandler(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        e.printStackTrace();
        return PublicRes.Error(ExceptionEnum.ERROR_SYSTEM_ERROR);
    }

}
