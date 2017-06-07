package com.wzd.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wzd.entity.User;

public class LoginInterceptor implements HandlerInterceptor {
	// 不拦截 "/login" 请求
	private static final String[] IGNORE_URI = { "/", "/user/login", "/letter/get/" };

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		System.out.println("This is afterCompletion!");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		System.out.println("This is postHandle!");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("This is preHandle!");
		// flag 表示是否登录
		boolean flag = false;
		// 获取请求的 URL
		String url = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (url.contains(s)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			// 获取 Session 并判断是否登录
			User admin = (User) request.getSession().getAttribute("admin");
			if (admin == null) {
				// 如果未登录，进行拦截，跳转到登录界面
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				flag = true;
			}
		}
		return flag;
	}

}
