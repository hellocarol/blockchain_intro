package com.sjh.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Pager<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private String recPositionLogo;			//顶端Logo图片（）
	private int pageSize; // 每页显示多少条记�?
	
	private int currentPage; //当前第几页数�?
	
	private int totalRecord; // �?��多少条记�?
	
	private int totalPage; // �?��多少页记�?
	
	private List<T> dataList; //要显示的数据
	
	private List<Double> pro=new ArrayList<Double>();//显示进度
	
	public Pager(int pageNum, int pageSize, List<T> sourceList){
		if(sourceList == null || sourceList.isEmpty()){
			return;
		}
		
		// 总记录条�?
		this.totalRecord = sourceList.size();
		
		// 每页显示多少条记�?
		this.pageSize = pageSize;
		
		//获取总页�?
		this.totalPage = this.totalRecord / this.pageSize;
		if(this.totalRecord % this.pageSize !=0){
			this.totalPage = this.totalPage + 1;
		}
		
		// 当前第几页数�?
		this.currentPage = this.totalPage < pageNum ?  this.totalPage : pageNum;
				
		// 起始索引
		int fromIndex	= this.pageSize * (this.currentPage -1);
		
		// 结束索引
		int toIndex  = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord : this.pageSize * this.currentPage;

		
		this.dataList = sourceList.subList(fromIndex, toIndex);
		
	}
	
	public Pager(){
		
	}

	public Pager(int pageSize, int currentPage, int totalRecord, int totalPage,
			List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.dataList = dataList;
	}
	
	public String getRecPositionLogo() {
		return recPositionLogo;
	}

	public void setRecPositionLogo(String recPositionLogo) {
		this.recPositionLogo = recPositionLogo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public List<Double> getPro() {
		return pro;
	}

	public void setPro(List<Double> pro) {
		this.pro = pro;
	}

}

	

