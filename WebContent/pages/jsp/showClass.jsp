<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${user.name }的博客空间</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/pages/css/showClass.css">
</head>
<body>
     <jsp:include page="head.jsp" ></jsp:include>
     <div class="body">
        <div class="main">
            <jsp:include page="message.jsp" ></jsp:include>
           	<div class="right">
                <table align="center"> 
                	<caption>查看所有分栏</caption>
                	<c:forEach var="list" items="${clist }">
	                	<tr>
							<td class="className"><div>${list.clazz }</div></td>
							<td class="claInput">
								<input type="hidden" name="cid" value="${list.id }" id="c${list.id }"> 
								<input type="text" class="input" name="className">
							</td>
							<td>
								<input type="button" class="btn btn1" fid="${list.id }" value="修改" formaction="<%=request.getContextPath() %>/EditFen">
							</td>
							<td>
								<input type="button" class="btn btn2" fid="${list.id }" value="删除" formaction="<%=request.getContextPath() %>/DeleteFen">
							</td>
						</tr>
                	</c:forEach>
				
				</table>
            </div>
        </div>
    </div>
<jsp:include page="bottom.jsp" ></jsp:include>
<script src="<%=request.getContextPath() %>/pages/js/jquery.js"></script>
<script>
    $(function(){
    	$(".btn1").on("click",function(){
    		var $cid = $(this).attr("fid");
    		var $className = $("#c"+$cid).next().val();
    		if(confirm("您确定要更改吗？"))
    			send($className,$cid);
    	})
    	function send(className,cid){
    		$.ajax({
                type : "get",
                url : "<%=request.getContextPath() %>/EditFen",
                async:true,
                cache : false,
                data : {
                    "className":className,
                    "cid":cid
                },
                dataType : "json",
                success : function(msg) {
                    alert(msg.info);
                	window.location.href="<%=request.getContextPath() %>/ShowFenServlet";
                },
                error : function() {
                    alert("更新失败！");
                }
            })
    	}
    	$(".btn2").on("click",function(){
    		var $cid = $(this).attr("fid");
    		if(confirm("您确定要删除吗？"))
    			sendDelete($cid);
    	})
    	function sendDelete(cid){
    		$.ajax({
                type : "get",
                url : "<%=request.getContextPath() %>/DeleteFen",
                async:true,
                cache : false,
                data : {
                    "cid":cid
                },
                dataType : "json",
                success : function(msg) {
                    alert(msg.info);
                	window.location.href="<%=request.getContextPath() %>/ShowFenServlet";
                },
                error : function() {
                    alert("删除失败！");
                }
            })
    	}
    })
</script>
</body>
</html>