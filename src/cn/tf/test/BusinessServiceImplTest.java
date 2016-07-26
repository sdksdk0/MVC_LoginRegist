package cn.tf.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import cn.tf.domain.User;
import cn.tf.exception.UserExistsException;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

public class BusinessServiceImplTest  {

	BusinessService bs = new BusinessServiceImpl();
	@Test
	public void testRegist() throws UserExistsException {
		User user = new User();
		user.setUsername("哦哦");
		user.setPassword("123");
		user.setEmail("lf@tianfang1314.cn");
		user.setBirthday(new Date());
		bs.regist(user);
	}
	
	@Test(expected=cn.tf.exception.UserExistsException.class)
	public void testRegist1() throws UserExistsException{
		User user=new User();
		user.setUsername("王大");
		user.setPassword("123");
		user.setEmail("wd@tianfang1314.cn");
		user.setBirthday(new Date());
		bs.regist(user);
	
	}
	
	
	@Test
	public void testLogin() {
		User user=bs.login("王大", "123");
		assertNotNull(user);
		user=bs.login("王大锤","123");
		assertNull(user);
	}

}
