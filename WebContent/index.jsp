<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>基金系统</title>

</head>
<body>
	<h1>FundSystem</h1>
	<hr/>
	<c:if test="${user==null}">
		<a href="${pageContext.request.contextPath }/servlet/RegisterUIServlet" target="_blank">注册</a>
		<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登陆</a>
	</c:if>
	<hr/>
</body>
</html>