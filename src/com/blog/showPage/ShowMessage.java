package com.blog.showPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.Clazz;
import com.blog.enity.Message;
import com.blog.sql.Select;

/**
 * @description 该类是用于展示一篇博客的详情信息。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/ShowMessage")
public class ShowMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		Message msg = Select.findMessage(mid);
		//查询点击信息对应的分类
		List<Clazz> list = Select.selectMessageClass(mid);
		request.setAttribute("msg", msg);
		request.setAttribute("msList", list);
		request.getRequestDispatcher("pages/jsp/showIndex.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
