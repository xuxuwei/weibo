package cn.newer.weibo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.newer.weibo.entity.TBlog;
import cn.newer.weibo.entity.TRview;
import cn.newer.weibo.entity.TUser;
import cn.newer.weibo.service.RviewServiceBase;
import cn.newer.weibo.utils.PageResult;

import com.opensymphony.xwork2.ActionContext;

/**
 * 评论  控制层
 * @author albin
 *
 */
public class RviewAction implements ServletRequestAware,ServletResponseAware{

	//request  response  对象
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String rcontent;
	private TRview rview;
	private Integer blogId;//博客ID
	
	//异步发送的数据   最终json
	private List<TRview> trviews ;
	
	private int currentPage = 1;//当前页
	private int maxResult = 2;//每页显示多少条
	
	//调用Service层
	private RviewServiceBase rviewService;
	public void setRviewService(RviewServiceBase rviewService) {
		this.rviewService = rviewService;

	}
	
	/**
	 * 评论分页
	 * @return
	 */
	public String getPage(){
		
		PageResult<TRview>  pageResult= this.rviewService.getByPage("", null, currentPage, maxResult);
		//放入作用域
		ActionContext.getContext().put("pageResult", pageResult);
		
		return "rview_list";
	}
	

	/**
	 * 发表评论   异步调用
	 * @return
	 */
	public String ajaxSave(){
	
		TUser user = (TUser) ActionContext.getContext().getSession().get("user");
		rview.setTUser(user);//评论用户
		
		TBlog blog = new TBlog();
		blog.setBlogid(blogId);//传递博客id
		rview.setTBlog(blog);//评论对应的博客
		
		this.rviewService.saveRview(rview); //保存
		
	
		//异步   返回给客户端的数据  （所有评论集合）
		trviews = this.rviewService.getRviewsByBid(blogId);
		
/*		try {
			//以流方式输出
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter pw = response.getWriter();
			pw.write("{\"id\":\"1\",\"name\":\"忘了\"}"); //给客户端返回的
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		return "aaa";
	}


	public TRview getRview() {
		return rview;
	}


	public void setRview(TRview rview) {
		this.rview = rview;
	}


	public String getRcontent() {
		return rcontent;
	}


	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}


	public Integer getBlogId() {
		return blogId;
	}


	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}


	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}


	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}


	public List<TRview> getTrviews() {
		return trviews;
	}


	public void setTrviews(List<TRview> trviews) {
		this.trviews = trviews;
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
	
	
}
