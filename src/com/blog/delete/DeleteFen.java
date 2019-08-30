package com.blog.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.blog.enity.User;
import com.blog.sql.Delete;
import com.blog.sql.Select;

/**
 * Servlet implementation class DeleteFen
 */
@WebServlet("/DeleteFen")
public class DeleteFen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFen() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		int flag = Select.selectAllMiddleByCid(cid);
		//如果flag为1表示含有分类下面还有文章，所以删除失败
		if(flag == 1) {
			System.out.println("DeleteFen:删除分类失败");
			response.getWriter().write("{\"info\":\"分栏下面含有文章删除失败\"}");
		}else {
			//再删除类表
			User user = (User)request.getSession().getAttribute("user");
			int uid = user.getId();
			System.out.println("DeleteFen:删除分类成功");
			Delete.deleteMiddle(cid);
			//删除分栏
			Delete.deleteFen(Integer.parseInt(cid),uid);
			response.getWriter().write("{\"info\":\"删除成功\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
