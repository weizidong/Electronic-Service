package com.wzd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/send")
	public String send() {
		return "letter/send";
	}
}
