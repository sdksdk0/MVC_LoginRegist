package cn.tf.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.tf.bean.FormBean;
import cn.tf.domain.User;
import cn.tf.exception.UserExistsException;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;
import cn.tf.util.WebUtil;

//完成新用户注册
public class RegistServlet extends HttpServlet {

	private BusinessService s=new BusinessServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//验证用户的输入，做服务器端的验证
		FormBean formBean=WebUtil.fillBean(request, FormBean.class);
		if(!formBean.validate()){
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}
		User user=new User();
	/*	user.setUsername(formBean.getUsername());
		user.setPassword(formBean.getPassword());
		user.setEmail(formBean.getEmail());
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			user.setBirthday(df.parse(formBean.getBirthday()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//调用业务方法
	/*	try {
			ConvertUtils.register(new Converter() {
				
				@Override
				public Object convert(Class type, Object value) {
					if(value instanceof String){
						String s=(String)  value;
						DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					
						try {
							return df.parse(s);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					return null;
				}
			}, Date.class);  //当遇到date类型的数据，需要转换时，要用前面的转换器
			
			
			BeanUtils.copyProperties(user, formBean);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			BeanUtils.copyProperties(user, formBean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		try {
			s.regist(user);	
		} catch (UserExistsException e) {
			
			formBean.getErrors().put("username","用户名已经存在");
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("/regist.jsp").forward(request,response);
			return;
		}
		
		//提示成功
				out.write("注册成功！2秒后自动转向主页");
				response.setHeader("Refresh", "2;URL="+request.getContextPath());
				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
