package okkpp.vo;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TestVO implements Serializable {

private static final long serialVersionUID = 1L;
	
	@NotNull(message = "密码不能为空")
	private java.lang.String password;
	
	@NotEmpty(message = "用户名不能为空")
	private java.lang.String username;
	
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

	@Override
	public String toString() {
		return "TestVO [password=" + password + ", username=" + username + "]";
	}
	
}
