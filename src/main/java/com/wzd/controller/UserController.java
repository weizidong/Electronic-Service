package com.wzd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wzd.dto.Msg;
import com.wzd.dto.PageInfo;
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
	// 登录
	@RequestMapping("/login")
	public String login(@BeanParam User u, HttpSession session, RedirectAttributes attr, Model model) {
		User user = userService.login(u.getUserid(), u.getPwd());
		if (user == null) {
			attr.addFlashAttribute("msg", Msg.error("账号或密码错误！"));
			return "redirect:/";
		}
		attr.addFlashAttribute("msg", Msg.success("登录成功！"));
		user.setPwd(null);
		session.setAttribute("user", user);
		if (user.getType() == 1) {
			return "redirect:/user/list";
		}
		return "redirect:/send";
	}
	// 注册
	@RequestMapping("/register")
	public String register(@BeanParam User u, RedirectAttributes attr) {
		userService.register(u);
		attr.addFlashAttribute("msg", Msg.success("用户注册成功！"));
		return "redirect:/user/list";
	}
	// 修改密码
	@RequestMapping("/changePwd")
	public String changePwd(@FormParam("pwd") String pwd, @FormParam("old") String old, HttpSession session,
			RedirectAttributes attr) {
		User u = (User) session.getAttribute("user");
		try {
			userService.changePwd(u.getId(), old, pwd);
		} catch (RuntimeException e) {
			attr.addFlashAttribute("msg", Msg.success(e.getMessage()));
		}
		session.removeAttribute("user");
		return "redirect:/";
	}
	// 列表
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "filed", required = false) String filed,
			@RequestParam(value = "word", required = false) String word, Model model) {
		PageInfo info = userService.find(page, pageSize, filed, word);
		model.addAttribute("data", info);
		return "user/list";
	}
}
