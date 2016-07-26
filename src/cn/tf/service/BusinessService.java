package cn.tf.service;

import cn.tf.domain.User;
import cn.tf.exception.UserExistsException;

public interface BusinessService {
	
	//完成用户注册
	void regist(User user) throws UserExistsException;
	
	//完成用户登录
	User login(String username,String password);

}
