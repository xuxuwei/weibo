<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


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
 </HEAD>

 <BODY>
 <center>
		<h1 style="font-size:24px;">所有日志列表</h1>
	</center>
  <div  id="select_list">
  <div style="margin-left:200px;">标题：<input type="text"/>&nbsp;&nbsp;&nbsp;
  内容：<input type="text"/>&nbsp;&nbsp;&nbsp;
  开始时间：<input type="text" id="startTime" name="startTime" cssClass="s_text"  cssStyle="width:160px;"
                       	 readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>&nbsp;&nbsp;&nbsp;
  结束时间： <input type="text" id="endTime" name="endTime" cssClass="s_text"  cssStyle="width:160px;"
                              readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd HH:mm'});"/>&nbsp;&nbsp;&nbsp;
  姓名：<input type="text"/>&nbsp;&nbsp;&nbsp;
  <input type="button" value="查询"/>
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
      <tr align="center">
        <td>济南军区1</td>
        <td>核心提示1</td>
        <td>2008-01-12</td>
        <td>张三</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;
		</td>
      </tr>      
	  <tr align="center">
        <td>济南军区2</td>
        <td>核心提示2</td>
        <td>2008-01-12</td>
        <td>李四</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;</td>
      </tr>
	  <tr align="center">
        <td>济南军区3</td>
        <td>核心提示3</td>
        <td>2008-01-12</td>
        <td>王五</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;</td>
      </tr> 
	   <tr align="center">
        <td>济南军区4</td>
        <td>核心提示4</td>
        <td>2007-01-12</td>
        <td>赵六</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;</td>
      </tr>      
	  <tr align="center">
        <td>济南军区5</td>
        <td>核心提示5</td>
        <td>2009-01-12</td>
        <td>田七</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;</td>
      </tr>
	  <tr align="center">
        <td>济南军区6</td>
        <td>核心提示6</td>
        <td>2007-01-12</td>
        <td>王五</td>
        <td><a href="findblog1.html">查看</a>&nbsp;&nbsp;</td>
      </tr> 
    </tbody>
    </table>
	<table align="center">
		<tr>
			<td><a href="main.html">返回主页</a></td>
		</tr>
	</table>
	<table align="center">
	<tr><td><a href="">[1]</a><a href="">[2]</a><a href="">[3]</a></td></tr>
	</table>
</div>
 </BODY>
</HTML>
