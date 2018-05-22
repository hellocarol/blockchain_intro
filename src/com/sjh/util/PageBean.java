package com.sjh.util;

import java.util.List;

public class PageBean<T> {
	private List<T> list;
	private int allRow;
	private int totalPage;
	private int currentPage;
	private int pageSize;
	private int count;
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean isPreviousPage;
	private boolean hasNextPage;
	private int id;

	public PageBean(int pageSize, int currentPage, int allRow, int totalPage,
			List<T> list) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.allRow = allRow;
		this.totalPage = totalPage;
		this.list = list;
	}

	public PageBean() {
	}

	public List<T> getList() {
		return this.list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getAllRow() {
		return this.allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean getIsFirstPage() {
		return this.currentPage == 1;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return this.currentPage == this.totalPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean getIsPreviousPage() {
		return (this.currentPage != 1) && (this.currentPage != 0);
	}

	public void setPreviousPage(boolean isPreviousPage) {
		this.isPreviousPage = isPreviousPage;
	}

	public boolean isHasNextPage() {
		return this.currentPage != this.totalPage;
	}

	public boolean getHasNextPage() {
		return this.hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void init() {
		this.isFirstPage = getIsFirstPage();
		this.isLastPage = isLastPage();
		this.isPreviousPage = getIsPreviousPage();
		this.hasNextPage = isHasNextPage();
	}

	public static int countTotalPage(int pageSize, int allRow) {
		int totalPage = (allRow + pageSize - 1) / pageSize;
		return totalPage;
	}

	public static int countOffset(int pageSize, int currentPage) {
		int offset = pageSize * (currentPage - 1);

		return offset;
	}

	public static int countCurrentPage(int page) {
		int curPage = page == 0 ? 1 : page;
		return curPage;
	}

	public int getCount() {
		if (this.currentPage < 1)
			this.currentPage = 1;
		return (this.currentPage - 1) * this.pageSize;
	}
}
