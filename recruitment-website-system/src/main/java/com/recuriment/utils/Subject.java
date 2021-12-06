package com.recuriment.utils;


import com.recuriment.domain.pojo.user.User;

/**
 * 认证主类
 *
 * @author
 */
public class Subject {

	private final static ThreadLocal<User> MEMBER_LOCAL = new ThreadLocal<>();

	/**
	 * 获取会员用户ID
	 *
	 * 写死是1
	 *
	 * @return
	 */
	public static int getUserId() {
		return MEMBER_LOCAL.get().getId();
	}

	/**
	 * 获取会员角色ID
	 *
	 * 写死是1
	 *
	 * @return
	 */
	public static int getRoleId() {
		return MEMBER_LOCAL.get().getRoleId();
	}

	/**
	 * 获取会员用户
	 *
	 * @return
	 */
	public static User getUser() {
		return MEMBER_LOCAL.get();
	}

	/**
	 * 设置当前线程会员用户信息
	 *
	 * @param members
	 */
	public static void putUser(User members) {
		MEMBER_LOCAL.set(members);
	}

	/**
	 * 删除当前线程用户信息 防止内存溢出
	 *
	 */
	public static void removeUser() {
		MEMBER_LOCAL.remove();
	}

}
