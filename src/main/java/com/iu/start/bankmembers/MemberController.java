package com.iu.start.bankmembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(value = "login", method = RequestMethod.GET) //절대경로로!
	public String login() {
		System.out.println("로그인 실행");
		return "member/login"; //servlet-context.xml에 앞뒤 url포함
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST) 
	public String login(BankMembersDTO bankMembersDTO) {
		System.out.println("DB에 로그인 실행");
		
		//	"redirect:다시접속할 URL주소(절대경로,상대경로)"
		return "redirect:../"; //상대경로 
	}
	
	
	//	/member/join GET
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("Join GET 실행");
		return "member/join";
	}
	
	
	//	/member/join POST
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("Join POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		return "redirect:./login";
	}
	
	
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("Search GET 실행");
	}
	
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public String getSearchByID(String search, Model model) throws Exception {
		System.out.println("Search POST 실행");
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
	}
	

}
