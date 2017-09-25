package cn.newer.weibo.web;

import cn.newer.weibo.entity.TUser;
import cn.newer.weibo.service.UserService;

import com.opensymphony.xwork2.ActionContext;

/**
 * 控制层   用户
 * @author albin
 *
 */
public class UserAction {

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//供页面传递参数
	private TUser user;

	/**
	 * 用户登录UI
	 * @return
	 */
	public String  loginUI(){
		
		return "loginUI";
	}	
	
	/**
	 * 用户登录
	 * @return
	 */
	public String  login(){
		
		if(this.user != null){
			//数据库查询
			TUser user = userService.getUserByNamePwd(this.user.getUsername(),this.user.getUserpass());
			if(user==null){//登录失败
				ActionContext.getContext().put("errorMessage","用户名或密码错误!");
				return "loginUI"; 
			}else{//登录成功
				//保存session作用域
				ActionContext.getContext().getSession().put("user",user);
			}
		}
		
		return "index";
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}

}
