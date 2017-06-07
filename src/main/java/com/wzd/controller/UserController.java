package com.wzd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wzd.entity.User;
import com.wzd.service.LetterService;
import com.wzd.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = "user", types = { User.class })
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private LetterService letterService;

	@RequestMapping("/login")
	public String login(@BeanParam User u, Model model) {
		System.out.println(u);
		User user = userService.login(u.getUserid(), u.getPwd());
		if (user == null) {
			model.addAttribute("msg", "账号或密码错误！");
			return "index";
		}
		model.addAttribute("user", user);
		if (user.getType() == 1) {
			return "redirect:/letter/list";
		}
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
