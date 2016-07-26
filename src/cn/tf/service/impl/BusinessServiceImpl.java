package cn.tf.service.impl;

import cn.tf.dao.UserDao;
import cn.tf.dao.impl.UserDaoImpl;
import cn.tf.domain.User;
import cn.tf.exception.UserExistsException;
import cn.tf.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	private UserDao userDao = new UserDaoImpl();
	public void regist(User user) throws UserExistsException {
		//判断参数是否OK
		if(user==null)
			throw new IllegalArgumentException("请输入注册信息");
		//检测用户名是否已经存在
		User dbUser = userDao.findByUsername(user.getUsername());
		if(dbUser!=null)
			throw new UserExistsException("用户名"+user.getUsername()+" 已经存在");
		//保存数据
		userDao.save(user);
	}

	public User login(String username, String password) {
		return userDao.find(username,password);
	}

}

