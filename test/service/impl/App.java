package service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newer.weibo.dao.BlogBaseDAO;
import cn.newer.weibo.dao.RviewBaseDAO;
import cn.newer.weibo.entity.TBlog;
import cn.newer.weibo.entity.TRview;
import cn.newer.weibo.service.BlogServiceBaseDAO;
import cn.newer.weibo.utils.PageResult;

public class App {

	//保存日志
	@Test
	public void save(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		BlogBaseDAO blogDao = (BlogBaseDAO) context.getBean("blogBaseDAOImpl");
		
		TBlog t = new TBlog();
		t.setContext("aaaaa");
		t.setCtime(new Timestamp(new Date().getTime()));
		
		blogDao.save(t);
		
	}
	
	//查询一条日志
	@Test
	public void get(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		BlogBaseDAO blogDao = (BlogBaseDAO) context.getBean("blogBaseDAOImpl");
		
		System.out.println(blogDao.get(1).getContext());
		
	}
	//查询所有日志
	@Test
	public void getAll(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		BlogBaseDAO blogDao = (BlogBaseDAO) context.getBean("blogBaseDAOImpl");
		
		System.out.println(blogDao.get(1).getContext());
		
		for(TBlog b : blogDao.getAll()){
			System.out.println(b.getContext());
		}
	}
	
	
	//分页查询所有日志
	@Test
	public void getAllPage(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		BlogServiceBaseDAO service = (BlogServiceBaseDAO) context.getBean("blogServiceBaseDAO");
		
		
		PageResult<TBlog> pageResult = service.getByPage("",null, 2, 2);
		
		System.out.println(pageResult.getTotalPage()+"总页数");
	}	
	
	//查询一条日志
	@Test
	public void get1(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		RviewBaseDAO rviewDao = (RviewBaseDAO) context.getBean("rviewBaseDAOImpl");
		
		System.out.println(rviewDao.get(85).getContext());
		
	}
	
	//查询一条日志
	@Test
	public void getAll1(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		RviewBaseDAO rviewDao = (RviewBaseDAO) context.getBean("rviewBaseDAOImpl");
		
		System.out.println(rviewDao.get(85).getContext());
		for(TRview b : rviewDao.getAll()){
			System.out.println(b.getContext());
		}		
	}		
	
	//保存评论
	@Test
	public void saveRview(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		RviewBaseDAO rviewDao = (RviewBaseDAO) context.getBean("rviewBaseDAOImpl");
		
		TRview t = new TRview();
		t.setContext("bbbbbbb");
		
		
		rviewDao.save(t);
		
	}	
}
