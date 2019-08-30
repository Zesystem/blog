<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改${user.name }的博客</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/editMessage.css">
</head>
<body>
<jsp:include page="head.jsp" ></jsp:include>
<div class="body">
    <div class="main">
      	<jsp:include page="message.jsp" ></jsp:include>
        <div class="right">
            <div class="fcontent">
                <ul>
                	<form action="<%=request.getContextPath() %>/UpdateMessage" method="post">
                		<li id="h" style="margin-top:0;">标题</li>
	                	<li id="li">
	                		<input type="hidden"  value="${msg.id }"  name="mid">
	                		<input type="text" id="title" value="${msg.title }"  name="title">
	                	</li>
	                	<li id="h">简介</li>
	                	<li id="li">
	                		<textarea id="desc" name="desc">${msg.desc }</textarea>
	                	</li>
	                	<li id="h">分类</li>
	                	<li id="li" class="d">
	                		<input type="hidden" name="fen1Id" value="${msList[0].id }">
	                		<input type="text" id="fen" value="${msList[0].clazz }"  name="fen1">
	                		<input type="hidden" name="fen2Id" value="${msList[1].id }">
	                		<input type="text" id="fen" value="${msList[1].clazz }"  name="fen2">
	                		<input type="hidden" name="fen3Id" value="${msList[2].id }">
	                		<input type="text" id="fen" value="${msList[2].clazz }"  name="fen3">
	                		<input type="hidden" name="fen4Id" value="${msList[3].id }">
	                		<input type="text" id="fen" value="${msList[3].clazz }"  name="fen4">
	                		<input type="hidden" name="fen5Id" value="${msList[4].id }">
	                		<input type="text" id="fen" value="${msList[4].clazz }"  name="fen5">
	                	</li>
	                	<li id="h">内容</li>
	                	<li id="li" class="content">
	                	<textarea id="text1" style="display:none" name="content"></textarea>
	                		<div id="editor">
						        <p>${msg.content }</p>
						    </div>
	                	</li>
	                	<li id="btn">
	                		<input type="submit" id="btns" value="确定" />
	                		<input type="reset" id="btns" value="重置" />
	                	</li>
                	</form>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="bottom.jsp" ></jsp:include>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/pages/js/wangEditor.min.js"></script>
<script type="text/javascript">
var E = window.wangEditor
var editor = new E('#editor');
var $text1 = $('#text1');
editor.customConfig.onchange = function (html) {
    $text1.val(html)
}
editor.create();
$text1.val(editor.txt.html());
</script>
</script>
</body>
</html>