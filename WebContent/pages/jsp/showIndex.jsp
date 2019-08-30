<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${msg.title }</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/showIndex.css">
</head>
<body>
<jsp:include page="head.jsp" ></jsp:include>
<div class="body">
    <div class="main">
        <jsp:include page="message.jsp" ></jsp:include>
        <div class="right">
            <div class="fcontent">
                <ul>
                    <li class="title"><h1>${msg.title }</h1>
                        <span class="date">${msg.time }</span>
                    </li>
					<li>
						<c:forEach var="mList" items="${msList }">
                    	 	<a href="<%=request.getContextPath() %>/ShowFenMessage?id=${mList.id }" id="${mList.id }" class="mfen">${mList.clazz }</a>&nbsp;&nbsp;&nbsp;
                    	</c:forEach>
					</li>
                    <li class="desc"><span class="jian">简介：</span>${msg.desc }</li>
                    <li class="hr"></li>
                    <li class="content">${msg.content }</li>
                    <li class="btn">
                        <input type="button" id="edit" value="编辑">
                        <input type="button" id="delete" value="删除">
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="bottom.jsp" ></jsp:include>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script>
$(function(){
	var $edit = $("#edit");
	var $delete = $("#delete");
	$edit.on("click",function(){
		console.log("edit");
		window.location.href = "<%=request.getContextPath() %>/EditMessage?mid="+${msg.id };
	})
	$delete.on("click",function(){
		console.log("delete");
		var result=confirm("您确定要删除这条信息吗？");
		console.log(result);
		if(result){
			window.location.href = "<%=request.getContextPath() %>/DeleteMessage?mid="+${msg.id };
		}else{
			return ;
		}	
			
	})
})
</script>
</body>
</html>