<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <HEAD>
  <TITLE>所有日志列表</TITLE>
  <META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
  <style>
  *{
	font-size:12px;
  }
  </style>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/datepicker/WdatePicker.js"></script>    
<!-- 导入jquery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	//翻页
	function pageChange(pageNo){
		//获取表单
		$("#currentPage").val(pageNo);//当前页
		$("#form1").submit();//提交表单
	}
	
	//下拉分页
	function jumpPage(){
		var selectPage = $("#jump option:selected").val();
		
		pageChange(selectPage);
		
		//alert($("#jump").val());
	}
</script>
 </HEAD>

 <BODY>
 <center>
		<h1 style="font-size:24px;">所有日志列表</h1>
	</center>
<!-- 条件查询         -->	
<form id="form1" action="${pageContext.request.contextPath}/blog_getBlogList" method="post">
<!--隐藏域    页码 --> 
<input id="currentPage" name="currentPage" type="hidden" > 
 
  <div  id="select_list">
  <div style="margin-left:200px;">标题：<input name="title" type="text" value="${title }"/>&nbsp;&nbsp;&nbsp;
  内容：<input name="content" type="text" value="${content}"/>&nbsp;&nbsp;&nbsp;
  开始时间：<input type="text" id="startTime" value="${startTime }" name="startTime" cssClass="s_text"  cssStyle="width:160px;"
                       	 readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm:ss'});"/>&nbsp;&nbsp;&nbsp;
  结束时间： <input type="text" id="endTime" value="${endTime }" name="endTime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm:ss'});"/>&nbsp;&nbsp;&nbsp;
 
  姓名：<input name="username" value="${username }" type="text"/>&nbsp;&nbsp;&nbsp;
  <input type="submit" value="查询"/>

 
  <br><br><br><br>
  </div>
  <table width="780" border="1"cellspacing="1" align="center">
      <thead>
	  <tr>
		<th>标题</th>
        <th>内容</th>
        <th>时间</th>
        <th>发表者</th>
        <th>操作</th>
      </tr>
	  </thead>
	  <tbody>
<!-- 遍历数据  start -->	  
<c:forEach items="${pageResult.data}" var="obj">  
      <tr align="center">
        <td>${fn:substring(obj.title,0, 5)}${fn:length(obj.title)>5 ? '...' : ''}</td>
        <td>${fn:substring(obj.context,0,10)}${fn:length(obj.context)>12 ? '...' : ''}</td>
        <td>${obj.ctime }</td>
        <td>${obj.TUser.username}</td>
        <td>
<a href="${pageContext.request.contextPath}/blog_getTblogById?blodId=${obj.blogid}">查看</a>&nbsp;&nbsp;
		</td>
      </tr>      
</c:forEach>
<!-- 遍历数据  end -->	 	
    </tbody>
    </table>
	<table align="center">
		<tr>
			<td><a href="main.html">返回主页</a></td>
		</tr>
	</table>
	
	
<!-- 动态导入页面 -->	
<%@include file="/public/fenye.jsp" %>

<%-- 静态导入页面 
<jsp:include page="/public/fenye.jsp"></jsp:include>
 --%>






	
</div>
</form> 
 </BODY>
</HTML>
