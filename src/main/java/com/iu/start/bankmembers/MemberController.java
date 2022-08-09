package com.iu.start.bankmembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value="/member/*")
//이 클래스는 Controller 역할
//Container에게 이 클래스의 객체 생성을 위임
public class MemberController {

	//	annotation
	//	@ : 설명+실행
	
	
	
	//	/member/login
	@RequestMapping(value = "login") //절대경로로!
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	
	//	/member/join GET
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("Join GET");
		
		return "member/join";
	}
	
	
	//	/member/join POST
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("Join POST");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "member/join";
	}
}
