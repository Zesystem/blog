package com.blog.hall;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.Clazz;
import com.blog.enity.Message;
import com.blog.enity.User;
import com.blog.sql.Select;

/**
 * Servlet implementation class ShowHallMessage
 */
@WebServlet("/ShowHallMessage")
public class ShowHallMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowHallMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String uid = request.getParameter("uid");
		User myUser = (User)request.getSession().getAttribute("user");
		if(myUser.getId() != (int)Integer.parseInt(uid)) {
			//获取对应的用户
			User user = Select.SelectUserByUid(uid);
			request.getSession().setAttribute("otherUser", user);
			System.out.println("ShowHallMessage:"+user);
			//查询对应的信息
			Message message = Select.selectMessagesByUidAndMid(uid, mid);
			List<Clazz> clist = Select.selectMessageClass(mid);
			
			request.setAttribute("message", message);
			request.setAttribute("clist", clist);
			
			request.getRequestDispatcher("pages/jsp/showHallMessage.jsp").forward(request, response);
		}else {
			response.sendRedirect("ShowMessage?mid="+mid);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
