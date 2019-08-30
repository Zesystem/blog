<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.name }的博客空间</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/message.css">
</head>
<body>
     
   <div class="left">
       <div>
           <ul>
               <li>
                   <h3>${user.name }</h3>
               </li>
               <li>
                   <h4 class="gexing">个性签名：</h4>
                   <p>${user.signature }</p>
               </li>
               <li>
                   <h4 class="account">账号：</h4>
                   <p>${user.username }</p>
               </li>
               <li>
                   <h4 class="iphone">电话：</h4>
                   <p>${user.phone }</p>
               </li>
               <li>
                   <h4 class="emails">邮箱：</h4>
                   <p>${user.email }</p>
               </li>
           </ul>
           <div class="fenlan">
               <h3>分栏：<span class="add">添加</span></h3>
               <div>
                  <c:forEach var="fen" items="${clazzList }">
           	 		<a class="fendemo" href="<%=request.getContextPath() %>/ShowFenMessage?id=${fen.id }" id="${fen.id }">${fen.clazz }</a>
           		</c:forEach>
               </div>
           </div>
       </div>
   </div>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script>
    $(function(){
    	var colorArr = ["#f25d3f","#f59b25","#e1eb2a","#41eb2a","#35e8cd","#57a9fa",
    		"#7c5bf5","#b608c9","#e32276","#070382","#b806c2","#8aede3","#9bf57f",
    		"#d9e874","#fa5350","#68e831","#7e820c","#366665","#099491","#819de3",
    		"#a675f0","#85077a","#eb2f5e"];
    	var $fendemo = $(".fendemo");
    	for(var i = 0;i < $fendemo.length;i++){
    		$($fendemo[i]).css("background",colorArr[Math.floor(Math.random()*(colorArr.length - 2) + 1)]);
    	}
    	$(".add").on("click",function(){
    		var className=prompt("请输入要添加的分栏名:");
    		if (className!=null && className!="")
    		{
    		   window.location.href="<%=request.getContextPath() %>/WriteClass?className="+className;
    		}
    	})
    })
</script>  
</body>
</html>