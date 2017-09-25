package cn.newer.weibo.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import cn.newer.weibo.entity.TBlog;
import cn.newer.weibo.service.BlogServiceBaseDAO;
import cn.newer.weibo.utils.PageResult;

import com.opensymphony.xwork2.ActionContext;

/**
 * 博客日志 控制层
 * @author albin
 *
 */
public class BlogAction{
	
	
	//接收页面查询参数
	private String title;//标题
	private String content;//内容
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String username;//姓名
	private Integer blodId;//博客日志id

	int currentPage = 1;//当前页
	int maxResult = 5;//每页显示5条    21%5==0 ? 21/5 : 21/5+1
	
	

	//调用公共的业务层
	private BlogServiceBaseDAO blogServiceBase;
	public void setBlogServiceBase(BlogServiceBaseDAO blogServiceBase) {
		this.blogServiceBase = blogServiceBase;
	}

	/**
	 * 查询所有日志
	 * @return
	 */
	public String getBlogList(){
		
		String wherehql = ""; //组拼hql条件
		List<Object> params = new ArrayList<Object>(); //封装参数
		//日期格式化类
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//查询条件
		if(StringUtils.isNotBlank(this.title)){//标题
			wherehql += " and o.title like ?";
			params.add("%"+this.title+"%");
		}
		if(this.content!=null && !"".equals(this.content)){//内容
			wherehql += " and o.context like ?";
			params.add("%"+this.content+"%");
		}	
		
		if(this.startTime!=null && !"".equals(this.startTime)){//开始时间
			wherehql += " and o.ctime > ?";
			try {
				//把字符串日期格式 转换 成 Date 类型
				params.add(dateFormat.parse(this.startTime));
			} catch (Exception e) {
			}
		}
		 
		
		if(this.endTime!=null && !"".equals(this.endTime)){//结束时间
			wherehql += " and o.ctime < ?";
			try {
				//把字符串日期格式 转换 成 Date 类型
				params.add(DateUtils.parseDate(this.endTime, "yyyy-MM-dd HH:mm:ss"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}	
		
		if(this.username!=null && !"".equals(this.username)){//用户姓名
			wherehql += " and o.TUser.username like ?";
			params.add("%"+this.username+"%");		
		}

	
		//放入request作用域
		PageResult<TBlog> pageResult = blogServiceBase.getByPage(wherehql, params, currentPage, maxResult);
		ActionContext.getContext().put("pageResult", pageResult);
		
		
		return "listblog_all";
	}
	
	/**
	 * 查询博客日志的详细信息
	 * @return
	 */
	public String getTblogById(){
		
		TBlog tblog = this.blogServiceBase.get(this.blodId);
		
		System.out.println("博客日志对应的评论："+tblog.getTRviews().size());
		
		//放入reques作用域，供页面调用
		ActionContext.getContext().put("tblog", tblog);
		
		return "findblog";
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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



	public Integer getBlodId() {
		return blodId;
	}

	public void setBlodId(Integer blodId) {
		this.blodId = blodId;
	}



	
	
}
