package cn.newer.weibo.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.newer.weibo.dao.RviewBaseDAO;
import cn.newer.weibo.entity.TRview;
import cn.newer.weibo.service.RviewServiceBase;
import cn.newer.weibo.utils.PageResult;

public class RviewServiceBaseImpl implements RviewServiceBase {

	private RviewBaseDAO tviewBaseDAO;
	public void setTviewBaseDAO(RviewBaseDAO tviewBaseDAO) {
		this.tviewBaseDAO = tviewBaseDAO;
	}
	

	public int save(TRview t) {
		return this.tviewBaseDAO.save(t);
	}

	public TRview get(Serializable id) {
		return this.tviewBaseDAO.get(id);
	}

	public int update(TRview t) {
		return this.tviewBaseDAO.update(t);
	}

	public int delete(Serializable id) {
		return this.tviewBaseDAO.delete(id);
	}

	public List<TRview> getAll() {
		return this.tviewBaseDAO.getAll();
	}

	public PageResult<TRview> getByPage(String wherehql, List<Object> params,
			int currentPage, int maxResult) {
		return this.tviewBaseDAO.getByPage( wherehql, params,
				 currentPage,  maxResult);
	}

	
	
	
	//扩展业务
	public Integer saveRview(TRview rview) {
		
		return this.tviewBaseDAO.saveRview(rview);
	}

	public List<TRview> getRviewsByBid(Integer bid) {
		return this.tviewBaseDAO.getRviewsByBid(bid);
	}



}
