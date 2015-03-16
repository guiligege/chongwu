package org.guili.ecshop.util.common.page;

import java.util.ArrayList;
import java.util.List;

/** 
 * 保存分页信息的类 
 *  
 *  
 */  
public class Pager {
    private int totalRows; // 总行数  
    private int pageSize = 10; // 每页显示的行数  
    private int currentPage; // 当前页号  
    private int totalPages; // 总页数  
    private int startRow; 	// 当前页在数据库中的起始行  
    private String linkUrl; // 要跳转的URL
    private List<Integer> results=new ArrayList<Integer>(4);//分页索引码
    private int pageindexsize=8;//每页最多显示的页码数
    
    public Pager() {  
    }  
  
    public Pager(int _totalRows) {  
        totalRows = _totalRows;  
        totalPages = totalRows / pageSize;  
        int mod = totalRows % pageSize;  
        if (mod > 0) {  
            totalPages++;  
        }  
        currentPage = 1;  
        startRow = 0;  
    }
    
    public Pager(int _totalRows,int pageSize) {
    	this.pageSize=pageSize;
        totalRows = _totalRows;  
        totalPages = totalRows / pageSize;  
        int mod = totalRows % pageSize;  
        if (mod > 0) {  
            totalPages++;  
        }  
        currentPage = 1;  
        startRow = 0;  
    } 
  
    /** 
     * 设定查询的起始行数 
     *  
     * @param currentPage 
     */  
    public void setStart(int currentPage) {  
        this.currentPage = currentPage;  
        startRow = (currentPage - 1) * pageSize;  
    }  
  
    public int getTotalRows() {  
        return totalRows;  
    }  
  
    public void setTotalRows(int totalRows) {  
        this.totalRows = totalRows;  
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
  
    public int getTotalPages() {  
        return totalPages;  
    }  
  
    public void setTotalPages(int totalPages) {  
        this.totalPages = totalPages;  
    }  
  
    public int getStartRow() {  
        return startRow;  
    }  
  
    public void setStartRow(int startRow) {  
        this.startRow = startRow;  
    }  
  
    public String getLinkUrl() {  
        return linkUrl;  
    }  
  
    public void setLinkUrl(String linkUrl) {  
        this.linkUrl = linkUrl;  
    }

	public List<Integer> getResults() {
		return results;
	}

	public void setResults(List<Integer> results) {
		this.results = results;
	}

	public int getPageindexsize() {
		return pageindexsize;
	}

	public void setPageindexsize(int pageindexsize) {
		this.pageindexsize = pageindexsize;
	}  
}  
