package com.blog.showPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.classinfo.UpClassInfo;
import com.blog.enity.Message;
import com.blog.enity.User;
import com.blog.sql.Select;
/**
 * @description 该类是用于登陆后，渲染主页。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前用户的用户名	
		User user =(User)request.getSession().getAttribute("user");
		String username = user.getUsername();
		//判断更新用户信息，主要用于更改资料后跳转这边，需要更新
		User newUser = Select.loginUser(username);
		int uid = user.getId();
		//更新session用户资料
		request.getSession().setAttribute("user", newUser);
		//更新分类信息
		UpClassInfo.upClassInfo(request, user);
		//用于分页
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr == null||pageIndexStr.equals(""))
			pageIndexStr="1";
		int pageIndex = Integer.parseInt(pageIndexStr);
		
		//获取博客条
		List<Message> list = Select.selectMessages(uid,pageIndex);
		int allMessageCount = Select.countMessageAll(uid);
		//返回到jsp
		request.setAttribute("messageList", list);
		request.setAttribute("allMessageCount", allMessageCount);
		request.setAttribute("pageIndex", pageIndex);
		
		request.getRequestDispatcher("pages/jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
