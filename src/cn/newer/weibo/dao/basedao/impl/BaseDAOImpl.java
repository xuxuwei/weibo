package cn.newer.weibo.dao.basedao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.newer.weibo.dao.basedao.BaseDAO;
import cn.newer.weibo.utils.PageResult;

/**
 * 公共的BaseDAO实现类
 * @author albin
 *
 * @param <T>
 */
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

	private Class<T> clazz;
	
	public BaseDAOImpl() {
	
		ParameterizedType paramterType = (ParameterizedType) this.getClass().getGenericSuperclass();
		
		clazz = (Class<T>) paramterType.getActualTypeArguments()[0];
		
	}

	public int save(T t) {
		Integer count = (Integer) getHibernateTemplate().save(t);
		return count;
	}

	public T get(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	public int update(T t) {
		getHibernateTemplate().update(t);
		return 0;
	}

	public int delete(Serializable id) {
		getHibernateTemplate().delete(get(id));
		return 0;
	}

	public List<T> getAll() {
		return getSession().createQuery("from "+clazz.getSimpleName()).list();
	}

	public PageResult<T> getByPage(String wherehql, List<Object> params,
			int currentPage, int maxResult) {

		//根据查询条件，返回总记录数 （为了计算总页数用）
		String hql = "select count(o) from "+clazz.getSimpleName()+" o  where 1=1 " +wherehql;
		Query query = getSession().createQuery(hql);
		//设置参数
		if(params != null && params.size() > 0){
			//设置参数
			for(int i=0;i<params.size();i++){
				query.setParameter(i,params.get(i));
			}
			
		}
		long totalCount = (Long) query.uniqueResult();//根据查询条件，返回总记录数
		
		//总页数
		int totalPage = (int) (totalCount%maxResult==0 ? totalCount/maxResult : totalCount/maxResult+1);
		
		//当前页大于总页数
		if(currentPage >totalPage){
			currentPage = totalPage;//最后一页
		}
		
		if(currentPage < 1){
			currentPage = 1;//第一页
		}		
		
		
		
		
		hql = "from "+clazz.getSimpleName()+" o  where 1=1 " +wherehql;
		query = getSession().createQuery(hql);
		
		if(params != null && params.size() > 0){
			//设置参数
			for(int i=0;i<params.size();i++){
				query.setParameter(i,params.get(i));
			}
			
		}
		//hibernate分页
		query.setFirstResult((currentPage-1)*maxResult);
		query.setMaxResults(maxResult);
		List<T> data = query.list(); //根据查询条件，返回数据
		
		
		//封装分页的属性
		PageResult<T> pageResult = new PageResult<T>();
		pageResult.setData(data); //分页的数据
		pageResult.setCurrentPage(currentPage);//当前页
		pageResult.setMaxResult(maxResult);//最大显示多少条记录
		   
		
		pageResult.setTotalPage(totalPage);//总页数
		
		
		return pageResult;
	}

}
