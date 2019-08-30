package com.blog.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.List;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.blog.enity.User;
import com.blog.sql.Update;

/**
 * @description 该类是用于上传文件。
 * @author Zesystem
 * @date 2019-8-24
 */
@WebServlet("/UploadImg")
public class UploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UploadImg() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取到tomcat位于系统的绝对磁盘路径,精确到项目下.此为:D:\apache-tomcat-8.0.36\wtpwebapps\JavaBlog\
		String tomcatPath =request.getSession().getServletContext().getRealPath("/");
		//此为:D:\apache-tomcat-8.0.36\wtpwebapps\JavaBlog
        tomcatPath = tomcatPath.substring(0,tomcatPath.length()-1);
        //此为:D:\apache-tomcat-8.0.36\wtpwebapps
        tomcatPath = tomcatPath.substring(0,tomcatPath.lastIndexOf("\\"));
        // 此为: D:\\apache-tomcat-8.0.36\\webapps\\upload\\
		//上传的位置
        String realPath = tomcatPath+"\\upload\\";
        System.out.println("UploadImg:上传头像的路径:"+realPath);
        //判断，该路径是否存在
        File file = new File(realPath);
        if(!file.exists())
            file.mkdir();
//        解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
//        解析request
        List<FileItem> items = null;
        
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		User user = (User)request.getSession().getAttribute("user");
	    int id = user.getId();
		String filename = null;
//        遍历
        for(FileItem fileItem:items){
            //进行判断，当前item对象是否是上传文件项。
            if(!fileItem.isFormField()){
                //不是普通表单项
                //获取上传文件的名称
                filename = id+"_"+fileItem.getName();
//                完成上传
                try {
					fileItem.write(new File(realPath,filename));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("UploadImg:上传头像失败！！");
					e.printStackTrace();
					return;
				}
//                删除临时文件
            }
        }
        String url = "http://" + request.getServerName()  + ":" + request.getServerPort()+ "/imgs";
        System.out.println(url);
        System.out.println("success");
        Update.updateLogo(url +"/"+ filename, id);
        request.getRequestDispatcher("IndexServlet").forward(request, response);
	}

}
