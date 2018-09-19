package okkpp.dto;

import java.io.Serializable;

public class RoleUrlDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.Long roleId;
	
	private java.lang.Long urlId;
	
	private java.util.Date created;
	
	private java.lang.Integer enable;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setRoleId(java.lang.Long roleId) {
		this.roleId = roleId;
	}
	
	public java.lang.Long getRoleId() {
		return this.roleId;
	}

	public void setUrlId(java.lang.Long urlId) {
		this.urlId = urlId;
	}
	
	public java.lang.Long getUrlId() {
		return this.urlId;
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

}
