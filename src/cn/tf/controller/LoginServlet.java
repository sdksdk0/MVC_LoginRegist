package cn.tf.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tf.domain.User;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	private BusinessService s=new BusinessServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user=s.login(username,password);
		if(user==null){
			out.write("错误的用户名或密码！1秒后自动转向登陆页面");
			response.setHeader("Refresh", "1;URL="+request.getContextPath()+"/login.jsp");
			return;
		}
		//登陆成功
		request.getSession().setAttribute("user", user);
		out.write("登陆成功！1秒后自动转向主页");
		response.setHeader("Refresh", "1;URL="+request.getContextPath());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
