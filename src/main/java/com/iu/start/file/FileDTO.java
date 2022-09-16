package com.iu.start.file;

public abstract class FileDTO {
	private Long fileNum;
	private String fileName; //하드디스크에 저장되는 이름
	private String oriName; //업로드할때 이름
	
	public Long getFileNum() {
		return fileNum;
	}
	public void setFileNum(Long fileNum) {
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
}
