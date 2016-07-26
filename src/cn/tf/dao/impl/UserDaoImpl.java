package cn.tf.dao.impl;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;

import cn.tf.dao.UserDao;
import cn.tf.domain.User;
import cn.tf.util.Dom4JUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public User findByUsername(String username) {
		try {
			Document document = Dom4JUtil.getDocument();
			Node node = document.selectSingleNode("//user[@username='"+username+"']");
			if(node==null){
				//一个都没有
				return null;
			}
			//找到了
			User user = new User();
			user.setUsername(node.valueOf("@username"));
			user.setPassword(node.valueOf("@password"));
			user.setEmail(node.valueOf("@email"));
			String sbirthday = node.valueOf("@birthday");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(df.parse(sbirthday));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void save(User user) {
		try {
			Document document = Dom4JUtil.getDocument();
			Element root = document.getRootElement();
			
			//格式化一下日期
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			root.addElement("user");
			
			root.addElement("user")
				.addAttribute("username", user.getUsername())
				.addAttribute("password", user.getPassword())
				.addAttribute("email", user.getEmail())
				.addAttribute("birthday", df.format(user.getBirthday()));
			
			Dom4JUtil.write2xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public User find(String username, String password) {
		try {
			Document document = Dom4JUtil.getDocument();
			Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(node==null){
				//一个都没有
				return null;
			}
			//找到了
			User user = new User();
			user.setUsername(node.valueOf("@username"));
			user.setPassword(node.valueOf("@password"));
			user.setEmail(node.valueOf("@email"));
			String sbirthday = node.valueOf("@birthday");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(df.parse(sbirthday));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

}
