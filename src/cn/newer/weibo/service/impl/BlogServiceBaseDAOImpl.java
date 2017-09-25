package cn.newer.weibo.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.newer.weibo.dao.BlogBaseDAO;
import cn.newer.weibo.dao.basedao.impl.BaseDAOImpl;
import cn.newer.weibo.entity.TBlog;
import cn.newer.weibo.service.BlogServiceBaseDAO;
import cn.newer.weibo.utils.PageResult;

/**
 * 博客日志的DAO实现类
 * @author albin
 *
 */
public class BlogServiceBaseDAOImpl  implements BlogServiceBaseDAO{

	private BlogBaseDAO blogBaseDAO;
	public void setBlogBaseDAO(BlogBaseDAO blogBaseDAO) {
		this.blogBaseDAO = blogBaseDAO;
	}
	
	

	public int save(TBlog t) {
		return this.blogBaseDAO.save(t);
	}

	public TBlog get(Serializable id) {
		return this.blogBaseDAO.get(id);
	}

	public int update(TBlog t) {
		return this.blogBaseDAO.update(t);
	}

	public int delete(Serializable id) {
		return this.blogBaseDAO.delete(id);
	}

	public List<TBlog> getAll() {
		return this.blogBaseDAO.getAll();
	}

	public PageResult<TBlog> getByPage(String wherehql, List<Object> params,
			int currentPage, int maxResult) {
		return this.blogBaseDAO.getByPage(wherehql,params,currentPage,maxResult);
	}


}
