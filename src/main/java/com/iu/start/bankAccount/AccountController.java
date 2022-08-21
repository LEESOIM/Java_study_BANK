package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankmembers.BankMembersDTO;

@Controller
@RequestMapping("/bankaccount/*")
public class AccountController {
	
	@Autowired
	private BankAccountService accountService;

	@RequestMapping(value="add.iu", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		System.out.println("통장개설 실행");
		System.out.println(bankAccountDTO.getBookNum());
		
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("success");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		
		int result = this.accountService.add(bankAccountDTO);
		return "redirect:../bankbook/list.iu";
	}
}
