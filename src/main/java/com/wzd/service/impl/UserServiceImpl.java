package com.wzd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.wzd.Dto.PageInfo;
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

	@Override
	public PageInfo find(Integer page, Integer pageSize, String filed, String word) {
		UserExample e = new UserExample();
		Criteria c = e.createCriteria();
		if ("name".equals(filed)) {
			c.andNameLike(word);
		}
		if ("type".equals(filed)) {
			c.andTypeEqualTo(Integer.parseInt(word));
		}
		if ("userid".equals(filed)) {
			c.andUseridLike(word);
		}
		e.setOrderByClause("id ASC");
		if (pageSize == null) {
			pageSize = 10;
		}
		if (page == null || page < 1) {
			page = 1;
		}
		PageInfo info = new PageInfo();
		if (pageSize > 0) {
			int all = userDao.countByExample(e);
			info.setAll(all);
			if (Math.ceil(all * 1.0 / pageSize) < page) {
				page = (int) Math.ceil(all / pageSize);
			}
			e.setOrderByClause("id ASC limit " + ((page - 1) * pageSize) + "," + (page * pageSize));
		}
		List<User> u = userDao.selectByExample(e);
		info.setList(u);
		return info;
	}

	@Override
	public void register(User u) {
		if (StringUtils.isNotBlank(u.getPwd())) {
			u.setPwd(CheckSumBuilder.getMD5(u.getPwd()));
		} else {
			u.setPwd(null);
		}
		userDao.insertSelective(u);
	}

	@Override
	public String changePwd(Integer id, String old, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
