package com.blog.basic;

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
 * @description 该类是用于注册用户名。
 * @author Zesystem
 * @date 2019-8-17
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		System.out.println("进入RegisterServlet");
		String username = request.getParameter("username");
		
		User user = Select.loginUser(username);
		String json;
		if(user == null){
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String signature = request.getParameter("signature");
			int result = Insert.insertRegister(username, password, phone, email, signature);
			if(result > 0){
				System.out.println("添加成功！！！");
				json = "{\"registerMsg\":\"注册成功\"}";
			}else{
				System.out.println("添加失败！！！");
				json = "{\"registerMsg\":\"注册失败\"}";
			}
		}else{
			json = "{\"registerMsg\":\"用户名已经存在！！！\"}";
		}
		
		response.getWriter().write(json);
	}

}
