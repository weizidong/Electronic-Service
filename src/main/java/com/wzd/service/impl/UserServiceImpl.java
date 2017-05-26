package com.wzd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzd.dao.UserDao;
import com.wzd.entity.User;
import com.wzd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public void create(User user) {
		userDao.insertSelective(user);
	}
}
