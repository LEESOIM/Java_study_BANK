package com.iu.start.util;

public class CommentPager {
	//Mapper에서 사용
	private Long bookNum;
	private Long startRow;
	private Long lastRow;
	
	private Long page; //파라미터로 넘어온 것을 담는다
	private Long perPage; //한 페이지당 몇개씩 담을거냐
	
	private Long totalPage;
	
	//startRow lastRow
	public void getRowNum() { //1-5 6-10 11-15
		startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		lastRow = this.getPage() * this.getPerPage();
	}
	
	//전체 페이지 갯수 계산
	public void makePage(Long totalCount) {
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount/this.getPerPage()!=0) {
			this.totalPage++;
		}
	}
	
	
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPage() {
		if(this.page==null || this.page<1)
			this.page=1L;
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(this.perPage==null || this.perPage<1) {
			this.perPage=5L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
		
}
