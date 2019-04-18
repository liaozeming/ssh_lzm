package cn.lzm.util;

import java.util.List;

public class PageBean {
	//当前页数
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//页面记录数
	private Integer pageSize;
//	总页数
	private Integer totalPage;
	//返回查询对象
	private List list;
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.pageSize=pageSize;
		this.currentPage=currentPage;
		
		//Integer返回null;
		if(this.currentPage==null)
		{
			this.currentPage=1;
		}
		if(this.pageSize==null)
		{
			//若每页条数没有指定，默认3条
		this.pageSize = 3;
		}
	
		//计算总页数
        this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
        
        //不能小于1
        if(this.currentPage<1)
        {
        	this.currentPage=1;
        }
        //判断当前页数是否超出范围
        if(this.currentPage>this.totalPage)
        {
        	this.currentPage=totalPage;
        }
	}
	
	//计算起始索引
	public int getStart()
	{
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	

}
