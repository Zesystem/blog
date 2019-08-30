package com.blog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description 该类是用于拦截资源和请求、设置编码。
 * @author Zesystem
 * @date 2019-8-15
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//System.out.println("filter");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		if(request instanceof HttpServletRequest ) {
			HttpServletRequest re = (HttpServletRequest) request;
			String url = re.getRequestURI();
			//System.out.println(url);
			if (url.endsWith(".jsp")||url.endsWith(".css")||url.endsWith(".js")||url.endsWith("LoginServlet")||url.endsWith(".png")||url.endsWith(".jpg")||url.endsWith("RegisterServlet")) {
				//System.out.println("不拦截 直接访问");
			} else {
				Object user = re.getSession().getAttribute("user");
				if (user == null || user.toString().equals("")) {
					//System.out.println("没有登录");
					((HttpServletResponse) response).sendRedirect("pages/jsp/login.jsp");
					return;
				}
			}
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
