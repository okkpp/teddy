package okkpp.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.String password;
	
	private java.lang.String username;
	
	private java.lang.String mood;
	
	private java.lang.Integer sex;
	
	private java.util.Date birthday;
	
	private java.util.Date created;
	
	private java.lang.Integer enable;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}

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

	public void setMood(java.lang.String mood) {
		this.mood = mood;
	}
	
	public java.lang.String getMood() {
		return this.mood;
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

	public void setCreated(java.util.Date created) {
		this.created = created;
	}
	
	public java.util.Date getCreated() {
		return this.created;
	}

	public void setEnable(java.lang.Integer enable) {
		this.enable = enable;
	}
	
	public java.lang.Integer getEnable() {
		return this.enable;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", password=" + password + ", username=" + username + ", mood=" + mood + ", sex="
				+ sex + ", birthday=" + birthday + ", created=" + created + ", enable=" + enable + "]";
	}

}
