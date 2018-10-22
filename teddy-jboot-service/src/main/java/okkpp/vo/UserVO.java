package okkpp.vo;

import java.io.Serializable;

public class UserVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.String password;
	
	private java.lang.String username;
	
	private java.lang.String phone;
	
	private java.lang.String email;
	
	private java.lang.Integer sex;
	
	private java.util.Date birthday;
	
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	
	public java.lang.String getUsername() {
		return this.username;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}

	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}
	
	public java.lang.Integer getSex() {
		return this.sex;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	public java.util.Date getBirthday() {
		return this.birthday;
	}

}
