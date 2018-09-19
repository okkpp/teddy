package okkpp.dto;

import java.io.Serializable;

public class WalletDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	
	private java.lang.Long userId;
	
	private java.math.BigDecimal balance;
	
	private java.util.Date created;
	
	private java.lang.Integer enable;
	
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}
	
	public java.math.BigDecimal getBalance() {
		return this.balance;
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
