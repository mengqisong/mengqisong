<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="Dylist.do" method="post">
		电影名称:<input type="text" name="dname"><br><br>
		<input type="submit" value="搜索">
	</form>
	<table>
		<tr>
			<td colspan="10">
				<input type="button" value="批量删除" onclick="deleteAll()">
				<a href="Dy_add.jsp"><input type="button" value="添加"></a>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" id="qx">全选/全不选
				<input type="checkbox" id="fx">反选
			</td>
			<td>电影名称</td>
			<td>电影介绍</td>
			<td>导演</td>
			<td>电影分类</td>
			<td>发行时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="g">
			<tr>
				<td>
					<input type="checkbox" value="${g.did }" class="ck">
				</td>
				<td>${g.dname }</td>
				<td>${g.djs }</td>
				<td>${g.dename }</td>
				<td>${g.tname }</td>
				<td>${g.time }</td>
				<td>
					<a href="Dy_update.jsp?did=${g.did }"><input type="button" value="修改"></a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>
				<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>
				<a href="?pageNum=${page.pages }">尾页</a>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	$("#qx").click(function(){
		$(".ck").prop("checked",$(this).prop("checked"))
	})
	
	$("#fx").click(function(){
		$(".ck").each(function(){
			this.checked=!this.checked
		})
	})
	
	function deleteAll() {
		var id=""
		$(":checked.ck").each(function(){
			id+=","+$(".ck").val();
		})
		
		did=id.substring(1)
		
		$.post("deleteAll.do",{"did":did},function(data){
			if (data) {
				alert("删除成功")
				location.href="Dylist.do"
			}
		},"json")
	}
</script>
</html>