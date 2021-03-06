package dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wzd.dto.WebException;
import com.wzd.entity.User;
import com.wzd.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private UserService userService = null;

	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() throws WebException {
		User user = new User();
		user.setName("超级管理员");
		user.setPwd("123456");
		user.setType(1);
		user.setUserid("admin");
		userService.register(user);
		// user = userService.getUserById(1);
		logger.info(JSON.toJSONString(user));
	}
}