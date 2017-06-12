package com.wzd.interceptor;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wzd.entity.User;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger log = LogManager.getLogger(LoginInterceptor.class);
	// 不拦截 "/login" 请求
	private static final String[] IGNORE_URI = { "/user/login", "/letter/get/" };

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		HttpSession session = request.getSession();
		Long start = (Long) session.getAttribute("start");
		log.debug("耗时：" + (System.currentTimeMillis() - start) + " ms");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// flag 表示是否登录
		boolean flag = false;
		// 获取请求的 URL
		String url = request.getServletPath();
		log.debug("请求：" + url);
		log.debug("参数：" + StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset()));
//		log.debug("参数：" + convertStreamToString(request.getInputStream()));
		HttpSession session = request.getSession();
		session.setAttribute("start", System.currentTimeMillis());
		for (String s : IGNORE_URI) {
			if (url.equals("/") || url.contains(s)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			// 获取 Session 并判断是否登录
			User admin = (User) session.getAttribute("user");
			if (admin == null) {
				// 如果未登录，进行拦截，跳转到登录界面
				request.getRequestDispatcher("/").forward(request, response);
			} else {
				flag = true;
			}
		}
		return flag;
	}

//	private static String convertStreamToString(InputStream is) {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		try {
//			while ((line = reader.readLine()) != null) {
//				sb.append(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return sb.toString().trim();
//	}
}
