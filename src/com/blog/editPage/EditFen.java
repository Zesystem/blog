package com.blog.editPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.blog.sql.Update;

/**
 * @description 该类是用于修改分类名字。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/EditFen")
public class EditFen extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditFen() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String className = request.getParameter("className");
		if(!className.equals("")) {
			Update.updateFen(className, cid);
			response.getWriter().write("{\"info\":\"修改成功\"}");
		}else {
			response.getWriter().write("{\"info\":\"您没有更改分栏信息\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
