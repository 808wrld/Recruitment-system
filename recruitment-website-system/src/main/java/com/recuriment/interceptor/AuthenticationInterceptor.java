package com.recuriment.interceptor;

import com.recuriment.aop.annotation.UserLoginToken;
import com.recuriment.common.enums.ExceptionEnum;
import com.recuriment.domain.pojo.user.User;
import com.recuriment.exception.BusinessException;
import com.recuriment.mapper.user.UserMapper;
import com.recuriment.utils.Subject;
import com.recuriment.utils.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 认证，权限交由网关处理
 *
 * @author
 */

public class AuthenticationInterceptor implements HandlerInterceptor {
    public static final String LOGIN_TOKEN_KEY = "X-Recuritment-Token";

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object) throws Exception {

        String token = httpServletRequest.getHeader(LOGIN_TOKEN_KEY);// 从 http 请求头中取出 token

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //  检查是否有UserLoginToken注释，有则认证
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new BusinessException(ExceptionEnum.AUTHENTICATION_ERROR_SIMPLE_PASSWORD);
                }
                // 获取 token 中的 user id
                Integer userId= UserTokenManager.getUserId(token);
                if (userId==null) {
                    throw new BusinessException(ExceptionEnum.AUTHENTICATION_ERROR_NO_AUTHORITY);
                }

                User user = userMapper.selectById(userId);
                if (user == null) {
                    throw new BusinessException(ExceptionEnum.AUTHENTICATION_ERROR_USER_NOT_EXIST);
                }
                Subject.putUser(user);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

        Subject.removeUser();

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
