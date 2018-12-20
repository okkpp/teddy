package okkpp.common.result;

import com.jfinal.plugin.activerecord.Page;

public class PagedResult<T> extends Result<T> {

	private int pageNo;
	private int pageSize;
	private int totalPage;
	private int totalRow;
	
	public <P> PagedResult(T data, Page<P> paginate) {
		this(data);
		this.pageNo = paginate.getPageNumber();
		this.pageSize = paginate.getPageSize();
		this.totalPage = paginate.getTotalPage();
		this.totalRow = paginate.getTotalRow();
	}
	public PagedResult(T data, int pageNo, int pageSize, int totalPage, int totalRow) {
		this(data);
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
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
	
	public int getTotalRow() {
		return totalRow;
	}
	
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
}
