package com.wzd.service;

import com.wzd.dto.PageInfo;
import com.wzd.entity.User;

public interface UserService {

	// 登录
	public User login(String userid, String pwd);

	// 用户列表
	public PageInfo find(Integer page, Integer pageSize, String filed, String word);

	// 注册用户
	public void register(User u);

	// 修改密码
	public void changePwd(Integer id, String old, String pwd);

	// 查找用户
	public User get(String userid);

	// 查找用户
	public User getById(Integer id);

}
