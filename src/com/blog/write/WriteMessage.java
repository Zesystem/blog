package com.blog.write;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.Clazz;
import com.blog.enity.User;
import com.blog.sql.Insert;
import com.blog.sql.Select;

/**
 * @description 该类是实现写入博客。
 * @author Zesystem
 * @date 2019-8-18
 */
@WebServlet("/WriteMessage")
public class WriteMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入WriteMessage");
		//获取提交上来的博客信息
		String title =request.getParameter("title");
		String desc = request.getParameter("desc");
		String content = request.getParameter("content");
		//获取用户id，这里是博客信息用户的唯一标识
		User user = (User)request.getSession().getAttribute("user");
		int uid = user.getId();
		//插入当前的时间
		java.util.Date date = new java.util.Date(); //获取当前时间
		java.sql.Date time = new java.sql.Date(date.getTime());
		
		
		int mid = Insert.insertMessage(title, desc, content, uid,time);
		//获取分类
		String fen1 = request.getParameter("fen1");
		String fen2 = request.getParameter("fen2");
		String fen3 = request.getParameter("fen3");
		String fen4 = request.getParameter("fen4");
		String fen5 = request.getParameter("fen5");
		//添加到分类表，返回分类的id
		Insert.insertFenDemo(fen1,mid,uid);
		Insert.insertFenDemo(fen2,mid,uid);
		Insert.insertFenDemo(fen3,mid,uid);
		Insert.insertFenDemo(fen4,mid,uid);
		Insert.insertFenDemo(fen5,mid,uid);
		
		//获取所有的分类信息
		List<Clazz> list = Select.selectClass(uid);
		request.getSession().setAttribute("clazzList", list);
		
		request.getRequestDispatcher("ShowMessage?mid="+mid).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
