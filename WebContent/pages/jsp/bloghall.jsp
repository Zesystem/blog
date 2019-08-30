<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博客大厅</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/blogHall.css">
</head>
<body>
     <jsp:include page="head.jsp" ></jsp:include>
     <div class="body">
        <div class="main">
            <div class="right">
                <ul>
                   <li mid="${message.id}" > 
                   
                        <div class="content" style="padding:0px;position:relative;">
                            <div id="blog">博客大厅</div>
                        </div>
                    </li>
                  <c:forEach var="message" items="${AllMessageList}">
                    <li mid="${message.id}" uid="${message.uid }"> 
                        <div class="title">
                            <span class="t"><a >${message.title }</a></span>
                            <span class="date">${message.time }</span>
                        </div>
                        <div class="content">
                            <div class="c">
                            	<a >${message.desc }</a>
                            	<span class="author">Created By ${message.author } </span>
                           </div>
                
                        </div>
                    </li>
                  </c:forEach>
                </ul>
                <div class="pages">
                    <div>
                        <form action="<%=request.getContextPath() %>/BlogHall">
                            <span>当前页：</span>
                            <span>${pageIndex}</span>
                            <span>/</span>
                            <span id="allCount"></span>
                            <input type="button" value="首&nbsp;&nbsp;&nbsp;页" id="index">
                            <input type="button" value="上一页" id="prev">
                            <input type="button" value="下一页" id="after">
                            <input type="button" value="尾&nbsp;&nbsp;&nbsp;页" id="final">
                            <input type="number" name="pageIndex" id="pageIndex" max="" min="1">
                            <input type="submit" value="跳&nbsp;&nbsp;&nbsp;转">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="bottom.jsp" ></jsp:include>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script>
	
    $(function(){
    	//分页功能
    	var $pageIndex = $("#pageIndex");
    	var $indexBtn = $("#index");
    	var $prev = $("#prev");
    	var $after = $("#after");
    	var $final = $("#final");
    	var $finalIndex;
    	var index = parseInt("${pageIndex}");
    	
    	if((parseInt("${allMessageCount}") % 10) == 0)
    		$finalIndex = Math.floor(parseInt("${allMessageCount}")/10);
    	else
    		$finalIndex = Math.floor(parseInt("${allMessageCount}")/10 + 1);
    	if($finalIndex == 0)
    		$finalIndex = 1;
    	$("#allCount").text($finalIndex);
    	$("input[type=number]").attr("max",$finalIndex);
    	console.log($finalIndex);
    	var sub = function(value){
    		console.log(value);
    		$pageIndex.val(value);
    		$("form")[0].submit();
    	}
    	$indexBtn.on("click",function(){
    		index = 1;
    		sub(index);
    	})
    	$prev.on("click",function(){
    		if(index > 1){
    			index--;
    			sub(index);
    		}
    	})
    	$after.on("click",function(){
    		if(index < $finalIndex){
    			index++;
    			sub(index);
    		}
    	})
    	$final.on("click",function(){
    		index = $finalIndex;
   			sub(index);
    	})
    	//
    	$('.right li').on("click",function(){
    		console.log("li click ");
    		var mid = $(this).attr("mid");
    		var uid = $(this).attr("uid");
    		window.location.href = "<%=request.getContextPath() %>/ShowHallMessage?mid="+mid+"&uid="+uid;
    	})
    })
</script>
</body>
</html>