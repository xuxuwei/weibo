package cn.newer.weibo.dao.impl;

import java.util.List;

import org.hibernate.Query;

import cn.newer.weibo.dao.RviewBaseDAO;
import cn.newer.weibo.dao.basedao.impl.BaseDAOImpl;
import cn.newer.weibo.entity.TRview;

/**
 * 评论的DAO实现类
 * @author albin
 *
 */
public class RviewBaseDAOImpl extends BaseDAOImpl<TRview> implements RviewBaseDAO {

	public Integer saveRview(TRview rview) {
		Integer count = (Integer) getHibernateTemplate().save(rview);
		return count;
	}

	public List<TRview> getRviewsByBid(Integer bid) {
		
		Query query = getSession().createQuery("from TRview o where o.TBlog.blogid = ?");
		//设置参数
		query.setParameter(0,bid);
		
		return query.list();
	}

}
