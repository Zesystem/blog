package com.blog.basic;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.classinfo.UpClassInfo;
import com.blog.enity.Clazz;
import com.blog.enity.User;
import com.blog.sql.Select;

/**
 * @description 该类是用于登陆请求。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//查询数据库
		User user = Select.loginUser(username);
		String json;
		if(user == null){
			json = "{\"loginMsg\":\"用户名不存在\"}";
			response.getWriter().write(json);
		}
		else
			if(user.getPassword().equals(password)){
				request.getSession().setAttribute("user", user);
				UpClassInfo.upClassInfo(request, user);
				json = "{\"loginMsg\":\"登陆成功\"}";
				response.getWriter().write(json);
			}
			else{
				json = "{\"loginMsg\":\"密码错误\"}";
				response.getWriter().write(json);
			}
	}
	
}
