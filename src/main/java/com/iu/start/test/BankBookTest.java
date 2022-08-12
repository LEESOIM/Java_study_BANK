package com.iu.start.test;

import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		Calendar now = Calendar.getInstance();
//		bankBookDTO.setBookNum(now.getTimeInMillis());
//		bankBookDTO.setBookName("텅장");
//		bankBookDTO.setBookRate(3.5);
		
		try {
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result==1);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			
			
//			ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//			System.out.println("일련번호"+"\t\t"+"통장명"+"\t"+"이자율"+"\t"+"판매여부");
//			System.out.println("------------------------------------------");
//			for(int i=0; i<ar.size(); i++) {
//				System.out.print(ar.get(i).getBookNum()+"\t");
//				System.out.print(ar.get(i).getBookName()+"\t");
//				System.out.print(ar.get(i).getBookRate()+"\t");
//				System.out.println(ar.get(i).getBookSale());
//			}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
			
			
//			bankBookDTO.setBookSale(1);
//			bankBookDTO.setBookNum(1659509814053L);
//			int result = bankBookDAO.setChangeSale(bankBookDTO);
//			System.out.println(result==1);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

//			bankBookDTO.setBookNum(16595110L);
//			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
//			
//			if(bankBookDTO != null) {
//			System.out.println(bankBookDTO.getBookNum());
//			System.out.println(bankBookDTO.getBookName());
//			System.out.println(bankBookDTO.getBookRate());
//			System.out.println(bankBookDTO.getBookSale());
//			} else {
//				System.out.println("정보없음");
//			}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
			
//			bankBookDTO.setBookName("해삐해삐");
//			bankBookDTO.setBookRate(11.1);
//			bankBookDTO.setBookNum(1660122561410L);
//			int result = bankBookDAO.setUpdate(bankBookDTO);
//			System.out.println(result==1);
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
			bankBookDTO.setBookNum(1660122561410L);
			int result = bankBookDAO.setDelete(bankBookDTO);
			System.out.println(result==1);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
