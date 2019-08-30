package com.blog.hall;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.Message;
import com.blog.sql.Select;

/**
 * Servlet implementation class BlogHall
 */
@WebServlet("/BlogHall")
public class BlogHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public BlogHall() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入BlogHall");
		
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr == null||pageIndexStr.equals(""))
			pageIndexStr="1";
		int pageIndex = Integer.parseInt(pageIndexStr);
		
		List<Message> mlist = Select.selectAllMessages(pageIndex);
		int allMessageCount = Select.countMessageAll();
		
		for (Message message : mlist) {
			String name = Select.addMessageName(message.getUid());
			message.setAuthor(name);
			System.out.println(message.getAuthor());
		}
		request.setAttribute("AllMessageList", mlist);
		request.setAttribute("allMessageCount", allMessageCount);
		request.setAttribute("pageIndex", pageIndex);
		request.getRequestDispatcher("/pages/jsp/bloghall.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
