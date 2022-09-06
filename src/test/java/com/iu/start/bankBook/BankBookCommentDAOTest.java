package com.iu.start.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankbook.BankBookCommentDAO;
import com.iu.start.bankbook.BankBookCommentDTO;
import com.iu.start.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	//@Test
	public void setCommentAddTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1662142263151L);
		bankBookCommentDTO.setWriter("ㅇㅅㅇ");
		bankBookCommentDTO.setContents("테스트");
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void getCommentListTest() throws Exception {
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(1662142263151L);
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		assertNotEquals(0, ar.size());
	}
}
