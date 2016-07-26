package cn.tf.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	
	public static <T>  T fillBean(HttpServletRequest request,Class<T>  clazz){
		T bean;
		try {
			bean = clazz.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
