package com.wzd.handler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StreamUtils;
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
		log.debug("请求：" + url);
		try {
			log.debug("参数：" + StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset()));
			log.error("异常：" + ex);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (modelAndView == null) {
			modelAndView = new ModelAndView("500");
			Map<String, Object> map = new HashMap<>();
			map.put("msg", ex.getMessage());
			modelAndView.addObject(map);
		}
		return modelAndView;
	}
}
