<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.name }写博客</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/writeMessage.css">
</head>
<body>
<jsp:include page="head.jsp" ></jsp:include>
<div class="body">
    <div class="main">
        <jsp:include page="message.jsp" ></jsp:include>
        <div class="right">
            <div class="fcontent">
                <ul>
                	<form action="<%=request.getContextPath() %>/WriteMessage" method="post">
                		<li id="h" style="margin-top:0;">标题</li>
	                	<li id="li">
	                		<input type="text" id="title" value=""  name="title">
	                	</li>
	                	<li id="h">简介</li>
	                	<li id="li">
	                		<textarea id="desc" name="desc" maxlength="30"></textarea>
	                	</li>
	                	<li id="h">分类</li>
	                	<li id="li" class="d">
	                		<input type="text" id="fen" value=""  name="fen1">
	                		<input type="text" id="fen" value=""  name="fen2">
	                		<input type="text" id="fen" value=""  name="fen3">
	                		<input type="text" id="fen" value=""  name="fen4">
	                		<input type="text" id="fen" value=""  name="fen5">
	                	</li>
	                	<li id="h">内容</li>
	                	<li id="li" class="content">
	                	<textarea id="text1" style="display:none" name="content"></textarea>
	                		<div id="editor">
						        <p></p>
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