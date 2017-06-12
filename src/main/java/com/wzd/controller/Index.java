package com.wzd.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzd.entity.User;
import com.wzd.service.UserService;
import com.wzd.utils.CheckSumBuilder;

@Controller
public class Index {
	@Resource
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/send")
	public String send() {
		return "letter/send";
	}

	@RequestMapping("/init/admin")
	public @ResponseBody String init() {
		User admin = userService.get("admin");
		if (admin == null) {
			userService.login("admin", CheckSumBuilder.getMD5("123456"));
		} else {
			userService.changePwd(admin.getId(), admin.getPwd(), CheckSumBuilder.getMD5("123456"));
		}
		return "letter/send";
	}
}
