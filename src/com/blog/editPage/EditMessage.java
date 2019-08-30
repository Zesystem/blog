package com.blog.editPage;

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
 * @description 该类是用于点击编辑博客文章时的中服务。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/EditMessage")
public class EditMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入EditMessage");
		//回去点击信息的id
		String mid = request.getParameter("mid");
		//根据id查询出该条博客的所有信息
		Message msg = Select.findMessage(mid);
		//根据该条博客信息查询所有的分类
		List<Clazz> list = Select.selectMessageClass(mid);
		//添加到域对象
		request.setAttribute("msg", msg);
		request.setAttribute("msList", list);
		
		request.getRequestDispatcher("pages/jsp/editMessage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
