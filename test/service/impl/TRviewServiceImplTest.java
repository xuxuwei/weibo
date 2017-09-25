package service.impl;

import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.newer.weibo.entity.TBlog;
import cn.newer.weibo.entity.TRview;
import cn.newer.weibo.service.RviewServiceBase;

public class TRviewServiceImplTest {


	@Test
	public void getRviewsByBid(){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml","beans-dao.xml","beans-service.xml"});
		
		RviewServiceBase service = (RviewServiceBase) context.getBean("rviewService");
		
//		List<TRview> rviews = service.getRviewsByBid(1);
		
		TBlog b = new TBlog();
		b.setBlogid(1);
		b.setContext("aaaa");
		
		String s = JSONArray.fromObject(b).toString();
		
		System.out.println(s);
	}
}
