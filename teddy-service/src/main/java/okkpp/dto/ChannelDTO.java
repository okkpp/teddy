package okkpp.dto;

import java.io.Serializable;

public class ChannelDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.String name;
	
	private java.util.Date created;
	
	private java.lang.Integer enable;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
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
