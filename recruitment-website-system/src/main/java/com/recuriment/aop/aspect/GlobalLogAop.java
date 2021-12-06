package com.recuriment.aop.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 全局HTTP日志
 *
 * @author
 */
@Aspect
@Component
@Slf4j
@Order(99)
public class GlobalLogAop  {


    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void globalLogPointCut() {
    }

    @Around("globalLogPointCut()")
    public Object recordGlobalLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取执行方法的类的名称（包名加类名）
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String servletPath = request.getServletPath();

        String className = joinPoint.getTarget().getClass().getName();
        // 获取实例和方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 记录日志
        StringBuffer info = new StringBuffer("");
        List<String> whiteLogPathList = getWhiteLogPathList();
        if (whiteLogPathList.contains(servletPath)) {
            return joinPoint.proceed();
        } else if (servletPath.contains("static")) {
            return joinPoint.proceed();
        }
        String operator = "";
        try {
            operator = "";
        } catch (Exception e) {
        }
        String role = "";
        if (!StringUtils.isEmpty(operator)) {
            role = "";
        }
        info.append("operator [" + operator + "] role [" + role + "] request [" + servletPath + "] ");
        info.append("call " + className + "." + method.getName() + " ");
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        //ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }
        try {
            info.append("params = " + JSON.toJSONString(arguments) + " ");
        } catch (Exception e) {
            info.append("params = " + arguments.toString() + " ");
        }
        long start = System.currentTimeMillis();
        // 执行方法获取返回值
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        try {
            info.append("returns = " + proceed + " " + "耗时 = " + (end - start) + " ms " + " " + "耗时级别 = " + changeLevel(end - start));
        } catch (Exception e) {
            info.append("returns = " + proceed + " ");
        }
        log.info(info.toString());
        // 返回
        return proceed;
    }

    private long[] level = {
            //0~9
            100, 200, 300, 400, 500, 600, 700, 800, 900,
            //10~18
            1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
            //19~27
            10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000
    };

    private String changeLevel(long ms) {
        try {
            for (int i = 0; i < level.length; i++) {
                if (ms < level[i]) {
                    return "level-" + i;
                }
            }
        } catch (Exception ex) {
            return "level-error";
        }
        return "level-max";
    }


    private List<String> getWhiteLogPathList() {
        List<String> whiteLogPathList = new ArrayList<>();
        whiteLogPathList.add("/login");
        whiteLogPathList.add("/work/help/getListToSMH");
        whiteLogPathList.add("/work/notice/getNoticeListOnFirstPage");
        whiteLogPathList.add("/login-check");
        return whiteLogPathList;
    }
}
