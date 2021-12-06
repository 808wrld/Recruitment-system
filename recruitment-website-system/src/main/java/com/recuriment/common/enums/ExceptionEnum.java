package com.recuriment.common.enums;

import lombok.Getter;

/**
 *
 * @Author lqp
 * @Date 2020/10/22 19:33
 **/
@Getter
public enum ExceptionEnum {

    AUTHENTICATION_ERROR_USER_NOT_EXIST(1201, "认证失败:[用户名不存在]"),
    AUTHENTICATION_ERROR_PASSWORD_NOT_MATCH(1202, "认证失败:[用户名或密码错误]"),
    AUTHENTICATION_ERROR_ACCOUNT_FREEZED(1203, "认证失败:[账户角色不符]"),
    AUTHENTICATION_ERROR_SIMPLE_PASSWORD(1301, "认证警告:[Token不存在]"),
    AUTHENTICATION_ERROR_NO_AUTHORITY(1302, "认证警告:[用户未授权]"),
    AUTHENTICATION_ERROR_NO_PERMISSION(9002, "认证失败:[您没有操作权限]"),
    ERROR_UNKNOWN_BUSINESS(1301, "系统异常:[未知的业务类型]"),
    ERROR_SYSTEM_ERROR(1302, "系统异常:[服务调用发生异常]"),

    USER_ADD_ERROR_EXISTS(1303, "添加失败:[用户已存在]"),


    RESUME_ERROR_DUPLICATE(2101, "投递简历失败:[您已投递，无法重复投递]"),
    RESUME_ERROR_NO_CURRICULUM_VITAE(2101, "简历投递失败:[请在个人中心上传您的简历]"),
    PARAMETER_MISSING(9001, "参数缺失"),
    ERROR_CUSTOMIZE_ERROR(9000, "自定义原因异常"),
    NEED_AUDITING(9999, "操作失败:[需要审核]");
    private int code;
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
