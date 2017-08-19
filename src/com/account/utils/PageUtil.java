package com.account.utils;

import java.util.List;

/**
 * 分页工具
 * @author Administrator
 *
 * @param <T>
 */
public class PageUtil<T> {

	private int pageTotal;	//总页数
	private int currentPage = 1;//当前页码
	private int pageSize = 10;	//每页大小
	private int totalCount = 0;	//总记录数
	private List<T> list;	//每页结果集
	private int begin; // 分页起点
	private int end; // 分页终点
	private String url;// 请求路径和参数
	
	public int getBegin() {
		// 在mapper.xml使用begin属性时，对其进行计算
		begin = (currentPage - 1) * pageSize;
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		this.end=pageSize;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageTotal() {
		return totalCount%pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PageUtil [pageTotal=" + pageTotal + ", currentPage="
				+ currentPage + ", pageSize=" + pageSize + ", totalCount="
				+ totalCount + ", list=" + list + "]";
	}
}
