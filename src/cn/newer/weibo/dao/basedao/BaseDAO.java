package cn.newer.weibo.dao.basedao;

import java.io.Serializable;
import java.util.List;

import cn.newer.weibo.utils.PageResult;


/**
 * 公共的DAO（crud）
 * @author albin
 *
 */
public interface BaseDAO<T> {

	//添加
	public int save(T t);
	
	//查询
	public T get(Serializable id);
	
	//修改
	public int update(T t);
	
	//删除
	public int delete(Serializable id);
	
	//查询所有记录
	public List<T> getAll();
	
	/**
	 * 
	 * @param wherehql     hql 条件查询
	 * @param params       条件参数
	 * @param currentPage  当前页  （页面加载默认第一页）
	 * @param maxResult    每页显示多少条
	 * @return
	 */
	public PageResult<T> getByPage(String wherehql,List<Object> params,int currentPage,int maxResult);
	
	
	
}
