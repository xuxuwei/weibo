package cn.newer.weibo.entity;

import org.apache.struts2.json.annotations.JSON;



/**
 * TRview entity. @author MyEclipse Persistence Tools
 */


public class TRview {


    // Fields    

     private Integer vid;
     private TBlog TBlog;
     private TUser TUser;
     private String context;


    // Constructors

    /** default constructor */
    public TRview() {
    }

    
    /** full constructor */
    public TRview(TBlog TBlog, TUser TUser, String context) {
        this.TBlog = TBlog;
        this.TUser = TUser;
        this.context = context;
    }

   
    // Property accessors

    public Integer getVid() {
        return this.vid;
    }
    
    public void setVid(Integer vid) {
        this.vid = vid;
    }

//    @JSON(serialize=false)  把对象禁止传到客户端
    public TBlog getTBlog() {
        return this.TBlog;
    }
    
    public void setTBlog(TBlog TBlog) {
        this.TBlog = TBlog;
    }
    
//    @JSON(serialize=false)
    public TUser getTUser() {
        return this.TUser;
    }
    
    public void setTUser(TUser TUser) {
        this.TUser = TUser;
    }

    public String getContext() {
        return this.context;
    }
    
    public void setContext(String context) {
        this.context = context;
    }
   








}