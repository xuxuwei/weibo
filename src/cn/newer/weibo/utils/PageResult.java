package cn.newer.weibo.utils;

import java.util.List;

/**
 * 分页结果集
 * @author albin
 *
 */
public class PageResult<T> {

	private int totalPage;//总页数
	
	private int currentPage;//当前页
	
	private int maxResult;//每页显示的数量
	
	/**分页的数据*/
	private List<T> data;
	

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
	
	
}
