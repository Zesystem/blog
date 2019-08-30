package com.blog.write;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.User;
import com.blog.sql.Insert;
import com.blog.sql.Select;

/**
 * Servlet implementation class WriteClass
 */
@WebServlet("/WriteClass")
public class WriteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		int uid = user.getId();
		String className = request.getParameter("className");
		int isClass = Select.findIsFen(className, uid);
		if(isClass == -1) {
			//如果类表中没有就添加分栏
			Insert.insertFen(className, uid);
			System.out.println("WriteClass:添加分栏表成功");
		}else {
			//如果有，不执行
			System.out.println("WriteClass:分栏表中含有分栏，无法添加");
		}
		request.getRequestDispatcher("IndexServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
