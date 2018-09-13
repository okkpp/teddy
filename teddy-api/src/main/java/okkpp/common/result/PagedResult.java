package okkpp.common.result;

public class PagedResult<T> extends Result<T> {

	private int pageNo;
	private int pageSize;
	private int total;
	
	public PagedResult(T data) {
		super(data);
		super.setCode(400);
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
