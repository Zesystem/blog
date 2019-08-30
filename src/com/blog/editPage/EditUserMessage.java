package com.blog.editPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.User;
import com.blog.sql.Select;
import com.blog.sql.Update;

/**
 * Servlet implementation class EditUserMessage
 */
@WebServlet("/EditUserMessage")
public class EditUserMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditUserMessage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String signature = request.getParameter("signature");
		String name = request.getParameter("name");
		String github = request.getParameter("github");
		//更新资料
		Update.updateUser(id, password, phone, email, signature, name,github);
		response.sendRedirect("IndexServlet");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
