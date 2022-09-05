package com.iu.start.bankBook;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankbook.BankBookCommentDAO;
import com.iu.start.bankbook.BankBookCommentDTO;

public class BankBookCommentDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void setBankBookCommentTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1662142253287L);
		bankBookCommentDTO.setWriter("ㅇㅅㅇ");
		bankBookCommentDTO.setContents("테스트");
		int result = bankBookCommentDAO.setBankBookComment(bankBookCommentDTO);
		assertEquals(1, result);
	}
}
