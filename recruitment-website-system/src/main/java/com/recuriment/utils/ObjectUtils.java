package com.recuriment.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;


public class ObjectUtils {


    /**
     * 判断对象中属性值是否全为空
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (null == object) {
            return true;
        }

        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * vo 转 dto
     * @param source
     * @param target
     * @return
     */
    public static Object transferEntity(Object source, Class<?> target){
        Object object = null;
        try {
            object = target.newInstance();
        } catch (Exception e) {

        }
        BeanUtils.copyProperties(source, object);
        return object;
    }

    /**
     * 把实体类对象抓换成Json
     *
     * @param object
     * @return
     */
    public static String parseObject2JsonString(Object object) {
        return JSON.toJSONString(object);
    }
}
