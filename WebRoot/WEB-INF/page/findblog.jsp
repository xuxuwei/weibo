<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<META NAME="Generator" CONTENT="EditPlus">
  <META NAME="Author" CONTENT="">
  <META NAME="Keywords" CONTENT="">
  <META NAME="Description" CONTENT="">
<title>查看日志</title>
<style type="text/css">
*{font-size:12px;}
#h1title{
	font-size:28px;
}
<!--
.style1 {
	font-size: 36px;
	font-weight: bold;
}
.style2 {font-size: 18px}
.style3 {font-size: 18}
.style4 {font-size: 16px}
.style7 {color: #009966; font-size: 16px; }
.style8 {color: #FF0000; font-size: 18px; }
-->
</style>

<!-- 导入jquery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){

	$("#sb").click(function(){   //点击评论， 请求action
		//评论发表内容
		var rcontent = $("#rcontent").val();
		var bid = $("#blogId").val();
		
		
		//异步请求
		$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/rview_ajaxSave",
		   data: {"rview.context":rcontent,"blogId":bid},
		   success: function(backData){  // struts2-json 
		        // backData  不需要解析   直接返回json
		   		$("#prview").html("");//清空
		   	
		   		var $span =""; //创建评论人对应的内容
		   	
		   		var rviews =  backData.trviews; //返回的所有的评论
		   		
		   		for(var i = 0; i< rviews.length;i++){
			 		//添加
			 		$("#prview").append($("<span class='style7'>评论人:"+rviews[i].TUser.username+"</span><br><span class='style8'>内容:"+rviews[i].context+"</span><br>"));
		   		}
		   }
		});	
	});
});
</script>




</head>

<body>
<form name="form1" method="post" action="">
<!-- 隐藏域  存放博客日志 id -->
<input type="hidden" id="blogId" value="${tblog.blogid }"> 

<div align="center" class="style1">
<H1 id=h1title>${tblog.title }</H1>
  </div>
<div class="style1">
  <P><span class="style2"><span class="style3"><span class="style4"><STRONG>${tblog.context }</STRONG></span></span></span></P>
  
</div>
<p id="prview">


<!--   遍历  博客日志  对应的  所有评论的信息 -->
<c:forEach items="${tblog.TRviews }" var="rview">
	<span class="style7">评论人：${rview.TUser.username }</span><br>
	<span class="style8">内容：${rview.context }</span><br>
</c:forEach>

</p>
<p><br>
  <strong>评论日志：</strong>
</p>
  <textarea id="rcontent" name="textarea" cols="50"></textarea><br>
  <input id="sb" type="button" value="发表"/>
<input type="button" onclick="window.location.href='index.html'" value="返回">
</form>
<div>
	<a href="">返回主页</a>
</div>
</body>
</html>