package com.iu.start.bankAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getListTest() throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("ㅇㅅㅇ");
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		assertEquals(1, ar.size());
	}
}
