package com.wzd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wzd.entity.Letter;
import com.wzd.entity.User;
import com.wzd.service.LetterService;
import com.wzd.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private LetterService letterService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		String userId = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		User user = userService.login(userId, pwd);
		if (user == null) {
			model.addAttribute("msg", "账号或密码错误！");
			return "index";
		}
		if (user.getType() == 1) {
			List<Letter> letters = letterService.find(1, 10, null, null);
			model.addAttribute("user", user);
			model.addAttribute("letters", letters);
			return "letter/list";
		}
		model.addAttribute("user", user);
		return "letter/one";
	}

	@RequestMapping("/get")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
}
