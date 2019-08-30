package com.blog.classinfo;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.blog.enity.Clazz;
import com.blog.enity.User;
import com.blog.sql.Select;

public class UpClassInfo {
	public static void upClassInfo(HttpServletRequest request,User user) {
		System.out.println("upClassInfo:"+user);
		if(user != null) {
			List<Clazz> list = Select.selectClass(user.getId());
			System.out.println("upClassInfo:"+list);
			request.getSession().setAttribute("clazzList", list);
		}
	}
}
