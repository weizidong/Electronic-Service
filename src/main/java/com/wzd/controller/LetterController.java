package com.wzd.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wzd.dto.Msg;
import com.wzd.entity.Letter;
import com.wzd.entity.User;
import com.wzd.enums.SMS;
import com.wzd.service.LetterService;
import com.wzd.service.UserService;
import com.wzd.utils.SMSUtil;

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
		System.out.println("page=" + page + ",pageSize=" + pageSize + ",filed=" + filed + ",word=" + word);
		List<Letter> letters = letterService.find(page, pageSize, filed, word);
		model.addAttribute("letters", letters);
		return "letter/list";
	}

	@RequestMapping("/get/{id}")
	public String get(@PathParam("id") Integer id, @FormParam("idCard") String idCard, @FormParam("code") String code,
			HttpServletRequest request, Model model, RedirectAttributes attr) {
		if (StringUtils.isNotBlank(idCard) && StringUtils.isNotBlank(code)) {
			Letter l = letterService.get(id, idCard, code);
			if (l == null) {
				attr.addFlashAttribute("msg", Msg.error("身份证或验证码错误！"));
			} else {
				model.addAttribute("letter", l);
			}
		} else {
			attr.addFlashAttribute("msg", Msg.error("身份证或验证码不能为空！"));
		}
		return "letter/one";
	}

	@RequestMapping("/send")
	public String send(@BeanParam Letter l, HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("send:" + l);
		User user = (User) session.getAttribute("user");
		System.out.println("admin:" + user);
		l = letterService.send(l);
		String url = request.getScheme() + "://" + request.getServerName() + "/get/" + l.getId();
		SMSUtil.send(SMS.summons, new String[] { l.getPhone() }, new String[] { l.getTarget(), user.getName(),
				l.getTitle(), url, l.getCode(), DateFormatUtils.format(l.getTrialTime(), "yyyy-MM-dd HH:mm") });
		model.addAttribute("msg", "发送成功!");
		return "redirect:/send";
	}
}
