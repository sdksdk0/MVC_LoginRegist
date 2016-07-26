package cn.tf.dao;

import cn.tf.domain.User;

public interface  UserDao {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return 如果不存在返回null
	 */
	User findByUsername(String username);
	/**
	 * 保存用户信息
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return 不存在返回null
	 */
	User find(String username, String password);


}
