package com.iu.start.test;

import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
//		Calendar now = Calendar.getInstance();
//		bankBookDTO.setBooknum(now.getTimeInMillis());
//		bankBookDTO.setBookname("텅장");
//		bankBookDTO.setBookrate(3.5);
		
		try {
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result==1);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			
			
//			ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//			System.out.println("일련번호"+"\t\t"+"통장명"+"\t"+"이자율"+"\t"+"판매여부");
//			System.out.println("------------------------------------------");
//			for(int i=0; i<ar.size(); i++) {
//				System.out.print(ar.get(i).getBooknum()+"\t");
//				System.out.print(ar.get(i).getBookname()+"\t");
//				System.out.print(ar.get(i).getBookrate()+"\t");
//				System.out.println(ar.get(i).getBooksale());
//			}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
			
			
//			bankBookDTO.setBooksale(1);
//			bankBookDTO.setBooknum(1659509814053L);
//			int result = bankBookDAO.setChangeSale(bankBookDTO);
//			System.out.println(result==1);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

			bankBookDTO.setBooknum(16595110L);
			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			
			if(bankBookDTO != null) {
			System.out.println(bankBookDTO.getBooknum());
			System.out.println(bankBookDTO.getBookname());
			System.out.println(bankBookDTO.getBookrate());
			System.out.println(bankBookDTO.getBooksale());
			} else {
				System.out.println("정보없음");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
