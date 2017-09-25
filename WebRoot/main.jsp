<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>微博系统</title>
</head>
<body>
	<div id="title" align="center"><h1>欢迎进入微博系统</h1></div>
	<div id="operation">
		<div id="link_student" align="center">
			<a href="${pageContext.request.contextPath }/blog_getBlogList">查看所有日志</a>
			<a href="listblog_byself.html">个人日志管理</a>
		</div>
	</div>
	
</body>
</html>
