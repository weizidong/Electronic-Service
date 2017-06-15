package com.wzd.service;

import com.wzd.dto.PageInfo;
import com.wzd.dto.WebException;
import com.wzd.entity.User;

public interface UserService {

	// 登录
	public User login(String userid, String pwd) throws WebException;

	// 用户列表
	public PageInfo find(Integer page, Integer pageSize, String filed, String word);

	// 注册用户
	public void register(User u) throws WebException;

	// 修改密码
	public void changePwd(Integer id, String old, String pwd) throws WebException;

	// 查找用户
	public User get(String userid);

	// 查找用户
	public User getById(Integer id);

	// 删除
	public void delete(Integer id);

	// 重置密码
	public void reset(Integer id);

}
