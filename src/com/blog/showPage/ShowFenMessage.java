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
import com.blog.enity.User;
import com.blog.sql.Select;

/**
 * Servlet implementation class ShowFenMessage
 */
@WebServlet("/ShowFenMessage")
public class ShowFenMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowFenMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入ShowFenMessage");
		
		User user =(User)request.getSession().getAttribute("user");
		int uid = user.getId();
		System.out.println("ShowFenMessage:uid:参数："+uid);
		
		
		//获取对应信息的id
		String cid = request.getParameter("id");
		if(cid != null) {
			request.getSession().setAttribute("cid", cid);
		}else {
			cid = (String) request.getSession().getAttribute("cid");
		}
		System.out.println("ShowFenMessage:cid:参数："+cid);
		Clazz clazz = Select.selectLinClass(uid, Integer.parseInt(cid));
		System.out.println("ShowFenMessage:clazz:"+clazz);
		
		//用于分页
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr == null||pageIndexStr.equals(""))
			pageIndexStr="1";
		int pageIndex = Integer.parseInt(pageIndexStr);
		
		//获取博客条
		int allMessageCount = Select.countMessageAll(uid, Integer.parseInt(cid));
		//获取分类的所有信息
		List<Message> mlist = Select.selectClassMessage(cid,uid,pageIndex);
		System.out.println("ShowFenMessage:mlist:参数："+mlist);
		
		//返回到页面
		request.setAttribute("allMessageCount", allMessageCount);
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("mlist", mlist);
		request.setAttribute("clazz", clazz);
		System.out.println("ShowFenMessage:"+mlist);
		request.getRequestDispatcher("/pages/jsp/showFenMessage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
