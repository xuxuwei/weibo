<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>微博系统</title>
<style>
#operation{
	font-size:14px;
}
.tip{
	color:red;
}
</style>


<!-- 导入jquery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

$(function(){
	$("#form1").submit(function(){
	
		var name = $.trim($("#username").val());
		var pass = $.trim($("#userpass").val());
		
		if(name==""){
			alert("请输入用户名");
			$("#username").focus();//文本框获取焦点
			return false;
		}else if(pass == ""){
			alert("请输入密码");
			$("#userpass").focus();
			return false;
		}
		
		return true;
		
	});
	
	
	
					$.ajax( {
					type    : "POST",
					url     : "${pageContext.request.contextPath}/blog_getBlogJson?time="+new Date().getTime(),
					data    : null,
					success : function(backDate,textStatus,ajax){
								//var array = backDate.setCity;
								//alert(backDate.blogsJson[0].title);
								
								//alert(backDate.tblog.title);
								
							  }
				} );
});

</script>


</head>
<body>
	<div id="title" align="center"><h1>欢迎进入微博系统</h1></div>
	<div id="operation">
		<div id="link_student" align="center">
<!-- 
${pageContext.request.contextPath}
 http://localhost:8090/weibo
 -->		
<form action="${pageContext.request.contextPath}/user_login" id="form1" name="form1" method="post" >
		    <table id="loginForm" width="629" height="207" cellpadding="0" cellspacing="0"> 
              <tr>
                <td colspan="3">
					<div align="center"><span class="tip">${errorMessage}</span>
			    </div></td>
              </tr>
			  <tr>
                <td width="235"><div align="right">登录用户：</div></td>
                <td width="231"><input id="username" type="text" name="user.username" style="width:200px;"/></td>
                <td width="161">
					<span class="tip">${errorUserMessage }</span>
				</td>
              </tr>
              <tr>
                <td><div align="right">用户密码：</div></td>
                <td><input type="text" id="userpass" name="user.userpass" style="width:200px;"/></td>
                <td><span class="tip">${errorPwdMessage }</span></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="登录" />
                <input type="reset"  value="取消" /></td>
                <td>&nbsp;</td>
              </tr>
            </table>
</form>

		</div>
	</div>
	
</body>
</html>
