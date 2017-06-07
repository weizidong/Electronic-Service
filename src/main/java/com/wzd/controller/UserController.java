package com.wzd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wzd.Dto.PageInfo;
import com.wzd.entity.User;
import com.wzd.service.LetterService;
import com.wzd.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("admin")
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private LetterService letterService;

	@RequestMapping("/login")
	public String login(@BeanParam User u, Model model) {
		System.out.println("login:" + u);
		User user = userService.login(u.getUserid(), u.getPwd());
		if (user == null) {
			model.addAttribute("msg", "账号或密码错误！");
			return "index";
		}
		user.setPwd(null);
		model.addAttribute("admin", user);
		if (user.getType() == 1) {
			return "redirect:/user/list";
		}
		return "redirect:/send";
	}

	@RequestMapping("/register")
	public @ResponseBody String register(@BeanParam User u, Model model) {
		System.out.println("register:" + u);
		userService.register(u);
		return "用户注册成功！";
	}

	@RequestMapping("/changePwd")
	public @ResponseBody String changePwd(@FormParam("pwd") String pwd, @FormParam("old") String old,
			HttpSession session, Model model) {
		User u = (User) session.getAttribute("user");
		System.out.println("old=" + old + ",pwd=" + pwd + ",user=" + u);
		String msg = userService.changePwd(u.getId(), old, pwd);
		if (msg != null) {
			model.addAttribute("msg", msg);
		}
		return "redirect:/user/list";
	}

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "filed", required = false) String filed,
			@RequestParam(value = "word", required = false) String word, Model model) {
		System.out.println("page=" + page + ",pageSize=" + pageSize + ",filed=" + filed + ",word=" + word);
		PageInfo info = userService.find(page, pageSize, filed, word);
		model.addAttribute("data", info);
		return "user/list";
	}
}
