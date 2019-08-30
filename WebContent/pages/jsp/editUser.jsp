<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改${user.name }的个人资料</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/editUser.css">
</head>
<body>
<jsp:include page="head.jsp" ></jsp:include>
<div class="body">
    <div class="main">
        <jsp:include page="message.jsp" ></jsp:include>
        <div class="right">
            <div class="fcontent">
                <ul>
                	<form method="post" action="<%=request.getContextPath() %>/UploadImg" enctype="multipart/form-data" >
	                	<li id="h" style="margin-top:0;">博主头像</li>
	                	<li id="li">
	                		 <c:choose>
			                	 <c:when test="${user.logoSrc ==\"\" }">   
			                	 	<img src="<%=request.getContextPath() %>/pages/images/logo_to.jpg" alt="">
								 </c:when>
								   
								 <c:otherwise> 
								 	<img src="${user.logoSrc }" alt="">
								 </c:otherwise>
			                </c:choose>
	                		<a href="javascript:;" class="file">更换头像
							    <input type="file" value="更换头像" id="file" accept="image/png,image/jpg" name="upload">
							</a>
	                		<a href="javascript:;" class="file">
	                			<input type="submit" id="upload" value="上传" >
	                		</a>
	                	</li>
                	</form>
                	<form  method="post" action="<%=request.getContextPath() %>/EditUserMessage">
                		<li id="h" style="margin-top:0;">博主名字</li>
	                	<li id="li">
	                		<input type="hidden"  value="${user.id }"  name="id">
	                		<input type="text" id="title" value="${user.name }"  name="name">
	                	</li>
	                	
	                	<li id="h">个性签名</li>
	                	<li id="li">
	                		<textarea id="desc" name="signature">${user.signature }</textarea>
	                	</li>
	                	
	                	<li id="h" style="margin-top:0;">博主手机号</li>
	                	<li id="li">
	                		<input type="text" id="title" value="${user.phone }"  name="phone">
	                	
	                	</li>
	                	
	                	<li id="h" style="margin-top:0;">博主邮箱</li>
	                	<li id="li">
	                		<input type="text" id="title" value="${user.email }"  name="email">
	                	</li>
	                	<li id="h" style="margin-top:0;">github</li>
	                	<li id="li">
	                		<input type="text" id="title" value="${user.github }"  name="github">
	                	</li>
	                	<li id="h" style="margin-top:0;">博主账号</li>
	                	<li id="li">
	                		<input type="text" id="title" value="${user.username }"  name="username" readonly="true">
	                	</li>
	                	<li id="h" style="margin-top:0;" >博主密码</li>
	                	<li id="li" class="pwd">
	                		<input class="show clearinput" type="password" id="title" value="${user.password }"  name="password">
	                		<div class="showPwd"><img alt="" src="../images/eye.png"></div>
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
<script>
	$(function(){
		var $showPwd = $(".showPwd");
		$showPwd.on("click",function(){
			console.log("aaaa");
			var type = $(".show").attr("type");
			if(type == "password")
				$(".show").attr("type","text");
			else
				$(".show").attr("type","password");
		})
	})
</script>
</body>
</html>