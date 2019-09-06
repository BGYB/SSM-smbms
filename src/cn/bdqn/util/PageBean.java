package cn.bdqn.util;

import java.util.List;

public class PageBean<T> {
	
	private int pageNo=1; //当前页
	private int pageSize=8;//每页数量
	private int totalCount;//总计录数
	private int totalPages;//总页数
	private List<T> pageList;//对应的集合
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo<1){
			this.pageNo=1;
		}else if(pageNo>totalPages && totalPages>0){
			this.pageNo=totalPages;
		}else{

			this.pageNo = pageNo;
		}
		
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	//总页数由总记录数计算
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(this.totalCount>0){
			this.totalPages=(totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
		}
		
	}
	
	//只读总页数
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public PageBean(int pageNo, int pageSize, int totalCount, int totalPages,
			List<T> pageList) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
		this.pageList = pageList;
	}
	public PageBean() {
		super();
	}

	
	
}
