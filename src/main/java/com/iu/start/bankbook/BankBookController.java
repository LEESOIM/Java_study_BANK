package com.iu.start.bankbook;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {

	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list() {
		System.out.println("LIST 실행");
		
		return "bankbook/list";
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(Long booknum) {
		System.out.println("DETAIL 실행");
		System.out.println("booknum : "+booknum);
		return "bankbook/detail";
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("ADD GET");
		return "bankbook/add";
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(String name, String rate) throws Exception {
		System.out.println("ADD POST");
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		Calendar now = Calendar.getInstance();
		bankBookDTO.setBooknum(now.getTimeInMillis());
		bankBookDTO.setBookname("name");
		bankBookDTO.setBookrate(Double.parseDouble("rate"));
		bankBookDTO.setBooksale(Integer.parseInt("1"));
		
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		return "bankbook/add";
	}
}
