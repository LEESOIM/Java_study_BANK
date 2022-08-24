package com.iu.start.util;

public class Pager {
	//멤버변수
	// - 파라미터를 담을 변수
	private Long page;
	
	// - jsp에서 꺼내서 사용할 변수
	private Long startNum;
	private Long lastNum;
	
	// - mapper에서 꺼내서 사용할 변수
	private Long startRow;
	private Long lastRow;
	
	// perPage 	: 한 페이지에 출력할 게시글의 갯수
	private Long perPage;
	// perBlock : 한 페이지에 출력할 하단 번호의 갯수
	private Long perBlock;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	
	//1. mapper에서 사용할 값 계산(시작번호와 끝번호를 가져와) 	글1~글10 글11~글20
	public void getRowNum() throws Exception {
		this.startRow = (this.getPage()-1)*this.getPerPage()+1; //null이 리턴되는걸 getter로 방지
		this.lastRow = (this.getPage())*getPerPage();
	}
	
	//2. jsp에서 사용할 값 계산
	public void getNum(Long totalCount) throws Exception {
		//2. totalCount(글의총개수)로 totalPage 구하기 		글101개/10=10..1 -> 11페이지
		Long totalPage = totalCount/this.getPerPage();
		if(totalPage%this.getPerPage() != 0) {
			totalPage++;
		}

		//3. 총 몇개의 블럭이 나오는가						11페이지/5=2..1 -> 3개블럭
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//4. 현재 블럭 구하기								9페이지/5=1..4 -> 2번째블럭
		Long curBlock = this.getPage()/this.getPerBlock(); 
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기				
		this.startNum = (curBlock-1)*this.getPerBlock()+1; //(2-1)*5+1=6번
		this.lastNum = curBlock*this.getPerBlock();		   //2*5=10번
	}
	
	
	
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPerBlock() {
		if(this.perPage==null) {
			this.perPage=5L;
		}
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
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
}
