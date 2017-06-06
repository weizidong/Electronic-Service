package com.wzd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzd.dao.UserDao;
import com.wzd.entity.User;
import com.wzd.entity.UserExample;
import com.wzd.entity.UserExample.Criteria;
import com.wzd.service.UserService;
import com.wzd.utils.CheckSumBuilder;

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

	@Override
	public User login(String userid, String pwd) {
		UserExample e = new UserExample();
		Criteria c = e.createCriteria();
		c.andUseridEqualTo(userid);
		c.andPwdEqualTo(CheckSumBuilder.getMD5(pwd));
		List<User> users = userDao.selectByExample(e);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
