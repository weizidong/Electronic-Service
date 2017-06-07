package com.wzd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wzd.entity.Letter;
import com.wzd.entity.User;
import com.wzd.service.LetterService;
import com.wzd.service.UserService;

@Controller
@RequestMapping("/letter")
public class LetterController {
	@Resource
	private UserService userService;
	@Resource
	private LetterService letterService;

	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) Integer page, 
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "filed", required = false) String filed, 
			@RequestParam(value = "word", required = false) String word, Model model) {
		System.out.println("page="+page+",pageSize="+pageSize+",filed="+filed+",word="+word);
		List<Letter> letters = letterService.find(page, pageSize, filed, word);
		model.addAttribute("letters", letters);
		return "letter/list";
	}

	@RequestMapping("/get")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
}
