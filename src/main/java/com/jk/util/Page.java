package com.jk.util;

/**
 * 分页信息
 * @author Administrator
 *
 */
public class Page {

	//当前页数
	private int pageIndex = 1;
	//每页条数
	private int pageSize = 3;
	//总页数
	private int pageCount;
	//总数据
	private int totalCount;
	//开始的位置
	private int startPos;
	//结束的位置
	private int endPos;
	
	/**
	 * 计算分页信息
	 */
	public void calculatePage(){
		//计算总页数
		if(totalCount % pageSize == 0){
			pageCount = totalCount / pageSize;
		} else {
			pageCount = totalCount / pageSize + 1;
		}
		//计算开始位置和结束的位置
		//开始位置 = 每页条数 * (当前页数 - 1)
		startPos = (pageSize * (pageIndex - 1))+1;
		//结束位置 = 页数*每页的条数
		endPos = pageIndex * pageSize;
	}
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getEndPos() {
		return endPos;
	}
	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}
}
