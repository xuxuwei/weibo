package cn.newer.weibo.dao;

import java.util.List;

import cn.newer.weibo.dao.basedao.BaseDAO;
import cn.newer.weibo.entity.TRview;

/**
 * 评论的接口类
 * @author albin
 *
 */
public interface RviewBaseDAO extends BaseDAO<TRview>{

	
	
	
	/**
	 * 保存一条数据
	 * @param rview
	 * @return
	 */
	public Integer saveRview(TRview rview);
	
	/**
	 * 根据 博客日志ID 查询所有的评论
	 * @param bid 日志id
	 * @return
	 */
	public List<TRview> getRviewsByBid(Integer bid);

}
