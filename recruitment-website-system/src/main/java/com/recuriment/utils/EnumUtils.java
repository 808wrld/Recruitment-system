package com.recuriment.utils;


import com.recuriment.common.enums.BaseEnum;

/**
 * @ClassName: EnumUtils
 * @Description: 枚举工具类
 */
public class EnumUtils {
	
	/**
	 * @Title: isInEnum
	 * @Description: 根据value查询是否存在枚举
	 * @param @param enumClass
	 * @param @param value
	 * @param @return 
	 */ 
	public static <E extends Enum<?> & BaseEnum> boolean isInEnum(Class<E> enumClass, Object value) {
		E[] enumConstants = enumClass.getEnumConstants();
		for(E e : enumConstants) {
			if(e.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @Title: TitleOf
	 * @Description: 根据value值获取title
	 * @param @param enumClass
	 * @param @param value
	 * @param @return 
	 */ 
	public static <E extends Enum<?> & BaseEnum> String TitleOf(Class<E> enumClass, Object value) {
		E[] enumConstants = enumClass.getEnumConstants();
		for(E e : enumConstants) {
			if(e.getValue().equals(value)) {
				return e.getTitle();
			}
		}
		return value == null ? "" : value.toString();
	}

}

