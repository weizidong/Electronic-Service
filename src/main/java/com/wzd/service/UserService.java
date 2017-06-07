package com.wzd.service;

import com.wzd.Dto.PageInfo;
import com.wzd.entity.User;

public interface UserService {

	// 登录
	public User login(String userid, String pwd);

	// 用户列表
	public PageInfo find(Integer page, Integer pageSize, String filed, String word);

	// 注册用户
	public void register(User u);

	// 修改密码
	public String changePwd(Integer id, String old, String pwd);
}
