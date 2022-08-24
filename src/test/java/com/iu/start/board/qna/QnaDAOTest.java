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
	
//	@Test
//	public void getListTest() throws Exception {
//		List<BoardDTO> ar = qnaDAO.getList();
//		assertEquals(1, ar.size());
//	}
	
//	@Test
	public void setAddTest() throws Exception {
		
		for(int i=0; i<100; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setTitle("제목Title "+i);
			qnaDTO.setContents("내용Contents "+i);
			qnaDTO.setWriter("ㅇㅅㅇ");
			int result = qnaDAO.setAdd(qnaDTO);
			
			if(i%10==0) {
				Thread.sleep(500); //10번 하고 0.5초 쉬었다가 일해라
			}
		}
		System.out.println("Finish");
	}
	
	@Test
	public void getCountTest() throws Exception {
		long count = qnaDAO.getCount();
		assertEquals(100L, count);
	}
	
//	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(61L);
		boardDTO = qnaDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
	
//	@Test
	public void setUpdateTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("제목수정");
		qnaDTO.setContents("내용수정");
		qnaDTO.setNum(62L);
		int result = qnaDAO.setUpdate(qnaDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDelete() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(62L);
		int result = qnaDAO.setDelete(qnaDTO);
		assertEquals(1, result);
	}
}
