package com.iu.start.bankmembers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private MemberService memberService;
	
	
	//	/member/login
	@RequestMapping(value = "login.iu", method = RequestMethod.GET) //절대경로로!
	public String login() {
		System.out.println("로그인 실행");
		return "member/login"; //servlet-context.xml에 앞뒤 url포함
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST) 
	public String login(HttpSession session, BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("DB에 로그인 실행");
		
		bankMembersDTO = memberService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		//HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		//	"redirect:다시접속할 URL주소(절대경로,상대경로)"
		return "redirect:../"; //상대경로 
	}
	
	
	//	/member/join GET
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("Join GET 실행");
		return "member/join";
	}
	
	
	//	/member/join POST
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("Join POST 실행");
		
		int result = memberService.setJoin(bankMembersDTO);
		System.out.println(bankMembersDTO.getUserName());
		System.out.println(bankMembersDTO.getPassword());
		return "redirect:./login.iu";
	}
	
	
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("Search GET 실행");
		//요청한uri 주소와 jsp경로명이 같으면 리턴을 안하고 void로 할 수 있다
	}
	
	
	@RequestMapping(value="search.iu", method=RequestMethod.POST)
	public String getSearchByID(String search, Model model) throws Exception {
		System.out.println("Search POST 실행");
		
		List<BankMembersDTO> ar = memberService.getSearchByID(search);
		model.addAttribute("list", ar);//jsp로 보낼 데이터를 model에 담는다
		return "member/list";
	}
	
	
	@RequestMapping(value="logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}

}
