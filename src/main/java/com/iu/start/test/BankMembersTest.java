package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankmembers.BankMembersDAO;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {

		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("ㅇㅅㅇ5");
		bankMembersDTO.setPassword("1234");
		bankMembersDTO.setName("임이");
		bankMembersDTO.setEmail("@naver.com5");
		bankMembersDTO.setPhone("010123456785");
		
		
		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result == 1);
			
			ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("ㅅ");
			for(int i=0; i<ar.size(); i++) {
				System.out.println(ar.get(i).getUsername());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
