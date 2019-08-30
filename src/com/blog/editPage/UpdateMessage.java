package com.blog.editPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.enity.User;
import com.blog.sql.Delete;
import com.blog.sql.Insert;
import com.blog.sql.Select;
import com.blog.sql.Update;

/**
 * @description 该类是用于更新博客文章信息，也就是EditMessage服务后的更新服务。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebServlet("/UpdateMessage")
public class UpdateMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户id
		User user = (User)request.getSession().getAttribute("user");
		int uid = user.getId();
		//回去请求过来的信息
		String mid = request.getParameter("mid");
		String title =request.getParameter("title");
		String desc = request.getParameter("desc");
		String content = request.getParameter("content");
		//更新信息
		Update.updateMessage(title, desc, content, mid);
		//获取五个分类的值
		String fen1 = request.getParameter("fen1");
		String fen2 = request.getParameter("fen2");
		String fen3 = request.getParameter("fen3");
		String fen4 = request.getParameter("fen4");
		String fen5 = request.getParameter("fen5");
		//获取五个分类的id
		String fen1Id = request.getParameter("fen1Id");
		String fen2Id = request.getParameter("fen2Id");
		String fen3Id = request.getParameter("fen3Id");
		String fen4Id = request.getParameter("fen4Id");
		String fen5Id = request.getParameter("fen5Id");
		//更新分类
		isFen(fen1,fen1Id,mid,uid);
		isFen(fen2,fen2Id,mid,uid);
		isFen(fen3,fen3Id,mid,uid);
		isFen(fen4,fen4Id,mid,uid);
		isFen(fen5,fen5Id,mid,uid);
		
		
		request.getRequestDispatcher("ShowMessage?mid="+mid).forward(request, response);
	}
	/**
	 * 更新分类，如果分类表中含有就更新，否则就添加
	 * @param fen 分类名
	 * @param fid 分类的id
	 * @param mid 信息的id
	 * @param uid 用户的id
	 */
	public static void isFen(String fen,String fid,String mid,int uid) {
		//判断fid分类的id是否存在，如果不存在，只能进行添加，类列表中原有的分类
		if(fid.equals("")||fid == null) {
			//判断获取的类的信息是否存在，如果存在就添加到中间表，为信息绑定上分类
			int cid = Select.findIsFen(fen, uid);
			if(cid != -1) {
				//说明分类表中含有这个分类，cid的值就是这个分类的id,添加中间表
				Insert.insertMiddle(Integer.parseInt(mid), cid);
				System.out.println("UpdateMessage:isFen:为信息添加上分类");
			}else {
				System.out.println("UpdateMessage:isFen:分栏不存在");
				return ;
			}
		}else {
		//判断fid分类的id是否存在，如果存在，只能进行删除操作，删除中间表，不是删除分类。
			if(fen.equals("")||fen == null) {
				Delete.deleteMiddleByMidAndCid(mid, fid);
				System.out.println("UpdateMessage:isFen:删除该信息上的分类");
			}
		}
		
		
//		//判断是否为空
//		if(!fen.equals("")&&fen!=null) {
//			System.out.println("UpdateMessage:isFen:方法fen参数"+fen+",fid参数:"+fid);
//			//数据库中是否含有该分类
//			int isConFen = Select.findIsFen(fen,uid);
//			System.out.println("UpdateMessage:isFen:根据fid查询到的对应的clazz:"+isConFen);
//			//如果含有，则更新
//			if(isConFen != -1) {
//				//更新
//				System.out.println("UpdateMessage:isFen:更新");
//				//如果是添加的新分类，之前没有的，就需要添加中间表
//				if(fid.equals("")) {
//					Insert.insertMiddle(Integer.parseInt(mid), isConFen);
//				}else {
//					//仅仅是更新一下类名，直接更新
//					Update.updateFen(fen,fid);
//				}
//			}else {
//			//如果没有该分类，就直接保存，添加分类和中间表，这里的fid不重要了。
//				System.out.println("UpdateMessage:isFen:保存");
//				int id = Insert.insertFen(fen,uid);
//				Insert.insertMiddle(Integer.parseInt(mid), id);
//			}
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
