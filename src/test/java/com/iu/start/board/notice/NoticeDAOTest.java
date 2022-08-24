package com.iu.start.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest() throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertEquals(1, ar.size());
//	}
	
	
//	@Test
	public void setAddTest() throws Exception {
		
		for(int i=0; i<100; i++) {
			NoticeDTO noticeDTO = new NoticeDTO(); 
			noticeDTO.setTitle("제목Title"+i);
			noticeDTO.setContents("내용Contents"+i);
			noticeDTO.setWriter("ㅇㅅㅇ");
			int result = noticeDAO.setAdd(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(500); //10번 하고 0.5초 쉬었다가 일해라
			}
		}
		System.out.println("Finish");
	}
	
	@Test
	public void getCountTest() throws Exception {
		long count = noticeDAO.getCount();
		assertEquals(100L, count);
	}
	
	@Test
	public void getDetailTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(305L);
		boardDTO = noticeDAO.getDetail(boardDTO);
		assertNotNull(boardDTO);
	}
	
//	@Test
	public void setUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("제목수정");
		noticeDTO.setContents("내용수정");
		noticeDTO.setNum(41L);
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
//	@Test
	public void setDeleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(41L);
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}
	
}
