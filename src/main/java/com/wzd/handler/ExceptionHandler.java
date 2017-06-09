package com.wzd.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 全局异常处理类.对后台直接抛往前台页面的异常进行封装处理.
 * 
 * @author weizidong
 *
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver {
	private static final Logger log = LogManager.getLogger(SimpleMappingExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = super.doResolveException(request, response, handler, ex);
		String url = request.getServletPath();
		log.error("controller error.url=" + url, ex);
		if (modelAndView == null) {
			modelAndView = new ModelAndView("/500");
			modelAndView.addObject("error.");
		}
		return modelAndView;
	}
}
