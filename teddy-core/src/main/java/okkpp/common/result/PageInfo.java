package okkpp.common.result;

import java.io.Serializable;

public class PageInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
