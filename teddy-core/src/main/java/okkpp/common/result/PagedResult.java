package okkpp.common.result;

public class PagedResult<T> extends Result<T> {

	private int pageNo;
	private int pageSize;
	private int totalPage;
	
	public PagedResult(T data, int pageNo, int pageSize, int totalPage) {
		this(data);
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}
	public PagedResult(T data) {
		super(data);
		super.setCode(Response.PAGED.getCode());
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
