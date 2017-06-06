package com.wzd.service;

import com.wzd.entity.User;

public interface UserService {
	// 根据ID获取
	public User getUserById(int userId);

	// 创建
	public void create(User user);

	// 登录
	public User login(String userid, String pwd);
}
