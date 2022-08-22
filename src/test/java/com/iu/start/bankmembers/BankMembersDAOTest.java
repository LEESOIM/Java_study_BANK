package com.iu.start.bankMembers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankmembers.BankMembersDAO;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankMembersDAOTest extends MyAbstractTest {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
//	@Test
//	public void setJoinTest() throws Exception {
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUserName("id2");
//		bankMembersDTO.setPassword("pw2");
//		bankMembersDTO.setName("name2");
//		bankMembersDTO.setEmail("email2");
//		bankMembersDTO.setPhone("051-00000");
//		int result = bankMembersDAO.setJoin(bankMembersDTO);
//		assertEquals(1, result);
//	}
	
	
	@Test
	public void getSearchTest() throws Exception {
		String search = "ㅇㅅㅇ";
		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		assertNotNull(ar.size());
	}
	
	
	@Test
	public void getLoginTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("ㅇㅅㅇ");
		bankMembersDTO.setPassword("1234");
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		assertNotNull(bankMembersDTO);
	}
	
	@Test
	public void getMyPage() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("ㅇㅅㅇ");
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		assertNotNull(bankMembersDTO);
	}

}
