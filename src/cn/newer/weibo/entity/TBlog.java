package cn.newer.weibo.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * TBlog entity. @author MyEclipse Persistence Tools
 */

public class TBlog  implements java.io.Serializable {

	

    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Integer blogid;
     private TUser TUser;
     private String title;
     private String context;
     private Timestamp ctime;
     private Integer vnum;
     private String path;
     /**一对多   播客日志  对应    评论集合*/
     private Set TRviews = new HashSet(0);


    // Constructors

    /** default constructor */
    public TBlog() {
    }

	/** minimal constructor */
    public TBlog(Timestamp ctime) {
        this.ctime = ctime;
    }
    
    /** full constructor */
    public TBlog(TUser TUser, String title, String context, Timestamp ctime, Integer vnum, String path, Set TRviews) {
        this.TUser = TUser;
        this.title = title;
        this.context = context;
        this.ctime = ctime;
        this.vnum = vnum;
        this.path = path;
        this.TRviews = TRviews;
    }

   
    // Property accessors

    public Integer getBlogid() {
        return this.blogid;
    }
    
    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return this.context;
    }
    
    public void setContext(String context) {
        this.context = context;
    }

    public Timestamp getCtime() {
        return this.ctime;
    }
    
    public void setCtime(Timestamp ctime) {
        this.ctime = ctime;
    }

    public Integer getVnum() {
        return this.vnum;
    }
    
    public void setVnum(Integer vnum) {
        this.vnum = vnum;
    }

    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public Set getTRviews() {
        return this.TRviews;
    }
    
    public void setTRviews(Set TRviews) {
        this.TRviews = TRviews;
    }
   








}