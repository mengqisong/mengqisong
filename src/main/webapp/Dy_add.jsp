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
	<form action="#">
		电影编号:<input type="text" name="did" id="did"><br><br>
		电影名称:<input type="text" name="dname" id="dname"><br><br>
		电影介绍:<input type="text" name="djs" id="djs"><br><br>
		导演:<input type="text" name="dename" id="dename"><br><br>
		电影分类:<span id="tid" name="tid"></span><br><br>
		发行时间:<input type="date" id="time" name="time"><br><br>
		<input type="button" value="保存" onclick="addDy()">
	</form>
</body>
<script type="text/javascript">
	$(function(){
		$.post("listType.do",function(data){
			for(var i in data){
				$("#tid").append("<input type='checkbox' value='"+data[i].tid+"' name='tid'>"+data[i].tname)
			}
		},"json")
	})
	
		
	function addDy() {
		$.post("addDy.do",$("form").serialize(),function(data){
			if (data) {
				alert("添加成功")
				location.href="Dylist.do"
			}else{
				alert("添加失败")
				location.href="Dy_add.jsp"
			}
		},"json")
	}
</script>
</html>