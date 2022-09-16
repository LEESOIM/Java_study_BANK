package com.iu.start.board.impl;

import com.iu.start.file.FileDTO;

public class BoardFileDTO extends FileDTO {
	private Long num; //글번호

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}
