package cn.newer.weibo.service;

import cn.newer.weibo.entity.TUser;

public interface UserService {

	/**
	 * 根据用户名和密码查询一条记录
	 * @param name  用户名
	 * @param password 密码
	 * @return
	 */
	public TUser getUserByNamePwd(String name,String password);
	
}
