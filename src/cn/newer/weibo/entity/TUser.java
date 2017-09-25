package cn.newer.weibo.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser  implements java.io.Serializable {


    // Fields    

     private Integer userid;
     private String username;
     private String userpass;
     private String email;
     private Set TBlogs = new HashSet(0);
     private Set TRviews = new HashSet(0);


    // Constructors

    /** default constructor */
    public TUser() {
    }

    
    /** full constructor */
    public TUser(String username, String userpass, String email, Set TBlogs, Set TRviews) {
        this.username = username;
        this.userpass = userpass;
        this.email = email;
        this.TBlogs = TBlogs;
        this.TRviews = TRviews;
    }

   
    // Property accessors

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return this.userpass;
    }
    
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public Set getTBlogs() {
        return this.TBlogs;
    }
    
    public void setTBlogs(Set TBlogs) {
        this.TBlogs = TBlogs;
    }

    public Set getTRviews() {
        return this.TRviews;
    }
    
    public void setTRviews(Set TRviews) {
        this.TRviews = TRviews;
    }
   








}