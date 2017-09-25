<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 底部分页   start -->	
	<table align="center">
	<tr>
		<td>
			总页数：${pageResult.totalPage}&nbsp;
			当前页${pageResult.currentPage}&nbsp;
<a href="javascript:pageChange('1');">			
			首页&nbsp;
</a>			
<a href="javascript:pageChange('${pageResult.currentPage-1}');" >		
			上一页&nbsp;
</a>	
<a href="javascript:pageChange('${pageResult.currentPage+1}');">		
			下一页&nbsp;
</a>

<a href="javascript:pageChange('${pageResult.totalPage}');">			
			尾页&nbsp;
</a>			
			跳转到
			<select id="jump" onchange="javascript:jumpPage();">
<c:forEach begin="1" end="${pageResult.totalPage }" var="i">	
				<option
				  
<c:if test="${i==pageResult.currentPage }">			  
				  selected="selected"
</c:if>					  
				  
				   value="${i }">${i }</option>
</c:forEach>		
			</select>
		</td>
	</tr>
	</table>
<!-- 底部分页   end -->	

