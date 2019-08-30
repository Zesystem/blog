package com.blog.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.sql.Delete;

/**
 * @description 该类用于删除博客文章。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		Delete.deleteMessage(mid);
		request.getRequestDispatcher("IndexServlet").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
