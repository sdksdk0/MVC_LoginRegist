package cn.tf.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

//与表单对应
public class FormBean {
	
	private String username;
	private String password;
	private String repassword;
	private String email;
	private String birthday;
	
	private Map<String,String>  errors=new HashMap<String,String>();
	

	public boolean validate(){
		//校验不正确的数据
		
		/*用户名：必须输入，且3~8位的字母组成<br/>
	  	密码：必须输入，3~8位的数组组成<br/>
	  	确认密码：和密码保持一致<br/>
	  	邮箱：必须输入，且要符合邮箱的格式<br/>
	  	生日：必须输入，符合yyyy-MM-dd的格式<br/>*/
		
		if("".equals(username.trim())){
			errors.put("username", "请输入用户名");
		}else if(!username.matches("[a-zA-Z]{3,8}")){
			errors.put("username", "3-8位的字母组成");
		}
		if("".equals(password)){
			errors.put("password", "请输入密码");
		}else if(!password.matches("\\d{3,8}")){
			errors.put("password", "3-8位的数字组成");
		}
		if(!repassword.equals(password)){
			errors.put("repassword", "两次密码不一致");
		}
		
		if("".equals(email)){
			errors.put("email", "请输入邮箱");
		}else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")){
				errors.put("email", "邮箱格式不对");
		}
		if("".equals(birthday)){
			errors.put("birthday", "请输入生日");
		}else {
			DateFormat  df=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				df.parse(birthday);
			} catch (ParseException e) {
				errors.put("birthday", "日期格式不对");
			}		
		}
		
		return errors.isEmpty();
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepassword() {
		return repassword;
	}


	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public Map<String, String> getErrors() {
		return errors;
	}


	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}


	@Override
	public String toString() {
		return "FormBean [username=" + username + ", password=" + password
				+ ", repassword=" + repassword + ", email=" + email
				+ ", birthday=" + birthday + ", errors=" + errors + "]";
	}


	public FormBean(String username, String password, String repassword,
			String email, String birthday, Map<String, String> errors) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.email = email;
		this.birthday = birthday;
		this.errors = errors;
	}


	public FormBean() {
		super();
	}
	
	
}
