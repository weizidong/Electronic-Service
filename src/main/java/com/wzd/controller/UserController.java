package com.wzd.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wzd.dto.PageInfo;
import com.wzd.dto.WebException;
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
		User user;
		try {
			user = userService.login(u.getUserid(), u.getPwd());
		} catch (WebException e) {
			attr.addFlashAttribute("msg", e);
			return "redirect:/";
		}
		attr.addFlashAttribute("msg", WebException.success("登录成功！"));
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
		try {
			userService.register(u);
		} catch (WebException e) {
			attr.addFlashAttribute("msg", e);
		}
		return "redirect:/user/list";
	}

	// 修改密码
	@RequestMapping("/changePwd")
	public String changePwd(@FormParam("pwd") String pwd, @FormParam("old") String old, HttpSession session,
			RedirectAttributes attr) {
		User u = (User) session.getAttribute("user");
		try {
			userService.changePwd(u.getId(), old, pwd);
		} catch (WebException e) {
			attr.addFlashAttribute("msg", e);
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

	// 根据id获取
	@RequestMapping("/get/{id}")
	public @ResponseBody User get(@PathVariable Integer id) {
		User user = userService.getById(id);
		return user;
	}

	// 删除
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}

	// 重置密码
	@RequestMapping("/reset/{id}")
	public void reset(@PathVariable Integer id) {
		userService.reset(id);
	}
}
