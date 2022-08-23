package com.iu.start.board.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;

public class QnaDAOTest extends MyAbstractTest {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getListTest() throws Exception {
		List<BoardDTO> ar = qnaDAO.getList();
		assertEquals(2, ar.size());
	}
	
	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(61L);
		boardDTO = qnaDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
//	@Test
	public void setAddTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("제목");
		qnaDTO.setContents("내용");
		qnaDTO.setWriter("작성자");
		int result = qnaDAO.setAdd(qnaDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setUpdateTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("제목수정");
		qnaDTO.setContents("내용수정");
		qnaDTO.setNum(62L);
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(62L);
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}
}
