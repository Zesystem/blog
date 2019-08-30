<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/head.css">
</head>
<body>
        <div class="head">
            <div class="main">
                <div class="logo">
	                <c:choose>
	                	 <c:when test="${user.logoSrc ==\"\" }">   
	                	 	<img src="<%=request.getContextPath() %>/pages/images/logo_to.jpg" alt="">
						 </c:when>
						   
						 <c:otherwise> 
						 	<img src="${user.logoSrc }" alt="">
						 </c:otherwise>
	                </c:choose>
                </div>
                <ul>
                	<li><a href="<%=request.getContextPath() %>/BlogHall">博客大厅</a></li>
                	<li><a href="<%=request.getContextPath() %>/IndexServlet">博客主页</a></li>
                	<li><a href="<%=request.getContextPath() %>/ShowFenServlet">查看分栏</a></li>
                    <li><a href="<%=request.getContextPath() %>/pages/jsp/writeMessage.jsp">写博客</a></li>
                    <li><a href="${user.github }" target="_blank">github</a></li>
                    <li><a href="<%=request.getContextPath() %>/pages/jsp/editUser.jsp">编辑资料</a></li>
                    <li><a href="<%=request.getContextPath() %>/OutServlet">退出</a></li>
                </ul>
            </div>
        </div>

</body>
</html>