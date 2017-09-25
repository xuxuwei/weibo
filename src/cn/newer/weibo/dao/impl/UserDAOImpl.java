package cn.newer.weibo.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.newer.weibo.dao.UserDAO;
import cn.newer.weibo.entity.TUser;

/**
 * 用户的DAO层
 * @author albin
 *
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	public TUser getUserByNamePwd(String name, String password) {
		
		String hql = "from TUser o where o.username = ? and o.userpass = ?";
		//返回查询对象
		Query query = getSession().createQuery(hql);
		//设置参数   0 开始
		query.setParameter(0, name);
		query.setParameter(1, password);
		
		TUser user = (TUser) query.uniqueResult(); //返回一条结果集
		
		return user;
	}

}
