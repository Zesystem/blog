<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${msg.title }</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/showHallMessage.css">
</head>
<body>
<jsp:include page="head.jsp" ></jsp:include>
<div class="body">
    <div class="main">
        <jsp:include page="message.jsp" ></jsp:include>
        <div class="right">
            <div class="fcontent">
                <ul>
                    <li class="title"><h1>${message.title }</h1>
                        <span class="date">${message.time }</span>
                    </li>
					<li>
						<c:forEach var="mList" items="${clist }">
                    	 	<a  id="${mList.id }" class="mfen">${mList.clazz }</a>&nbsp;&nbsp;&nbsp;
                    	</c:forEach>
					</li>
                    <li class="desc"><span class="jian">简介：</span>${message.desc }</li>
                    <li class="hr"></li>
                    <li class="content">${message.content }</li>
                    <li class="author">Created By ${otherUser.name } </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="bottom.jsp" ></jsp:include>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
</body>
</html>