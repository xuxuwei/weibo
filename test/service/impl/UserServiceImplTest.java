package service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newer.weibo.entity.TUser;
import cn.newer.weibo.service.UserService;

public class UserServiceImplTest {

	/**
	 * 根据用户名和密码查询一条记录
	 * @param name  用户名
	 * @param password 密码
	 * @return
	 */
	@Test
	public void getUserByNamePwd(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		UserService service = (UserService) context.getBean("userService");
		
		TUser user = service.getUserByNamePwd("admin","admin");
		
		System.out.println(user.getUsername());
	}
}
