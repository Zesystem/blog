package com.blog.showPage;

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
 * @description 该类是用户点击查看分栏后获取分栏信息，并且请求转发到对应的页面
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/ShowFenServlet")
public class ShowFenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShowFenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		int uid = user.getId();
		List<Clazz> clist = Select.selectClass(uid);
		request.setAttribute("clist", clist);
		UpClassInfo.upClassInfo(request, user);
		request.getRequestDispatcher("pages/jsp/showClass.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
