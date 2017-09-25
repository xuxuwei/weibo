package cn.newer.weibo.service.impl;

import cn.newer.weibo.dao.UserDAO;
import cn.newer.weibo.entity.TUser;
import cn.newer.weibo.service.UserService;

/**
 * 业务层
 * @author albin
 *
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	

	public TUser getUserByNamePwd(String name, String password) {
		return this.userDAO.getUserByNamePwd(name, password);
	}

}
