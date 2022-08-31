package com.iu.start.bankmembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankAccount.BankAccountService;

@Controller 
@RequestMapping(value="/member/*")
//이 클래스는 Controller 역할
//Container에게 이 클래스의 객체 생성을 위임
public class MemberController {

	//	annotation
	//	@ : 설명+실행
	@Autowired
	private MemberService memberService;
	@Autowired
	private BankAccountService bankAccountService;
	
	
	//	/member/login
	@RequestMapping(value = "login.iu", method = RequestMethod.GET) //절대경로로!
	public String login() {
		System.out.println("로그인 실행");
		return "member/login"; //servlet-context.xml에 앞뒤 경로 추가해줌
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST) 
	public String login(HttpSession session, BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("로그인 성공");
		bankMembersDTO = memberService.getLogin(bankMembersDTO);
		//HttpSession session = request.getSession();
		session.setAttribute("success", bankMembersDTO);
		
		//	"redirect:다시접속할 URL주소(절대경로/상대경로)"
		return "redirect:../"; //상대경로 
	}
	
	@GetMapping("join_agree.iu")
	public String getAgree() throws Exception {
		return "member/join_agree";
	}
	
	
	//	/member/join_check GET
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public void join() {
		System.out.println("회원가입 실행");
		//return "member/join";
		//요청한uri 주소와 jsp경로명이 같으면 리턴을 안하고 void로 할 수 있다
	}
	
	//	/member/join POST
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("회원가입 성공");
		int result = memberService.setJoin(bankMembersDTO, photo, session.getServletContext());
		System.out.println(bankMembersDTO.getUserName());
		System.out.println(bankMembersDTO.getPassword());
		
		System.out.println("upload 파일명 : "+photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+photo.getName());
		System.out.println("upload 파일크기 : "+photo.getSize());
		
		return "redirect:login.iu";
	}
	
	
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("아이디찾기 실행");
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.POST)
	public String getSearchByID(String search, Model model) throws Exception {
		System.out.println("아이디찾기 성공");
		List<BankMembersDTO> ar = memberService.getSearchByID(search);
		model.addAttribute("list", ar);//jsp로 보낼 데이터를 model에 담는다
		return "member/list";
	}
	
	
	
	@RequestMapping(value="logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		System.out.println("로그아웃 성공");
		session.invalidate();
		return "redirect:../";
	}
	
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView myPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("success");
//		Map<String, Object> map = memberService.getMyPage(bankMembersDTO); (1)
//		mv.addObject("map", map);
		
		bankMembersDTO = memberService.getMyPage(bankMembersDTO); //(3)		
		//List<BankAccountDTO> ar = bankAccountService.getListByUserName(bankMembersDTO); (2)
		//mv.addObject("list", ar);
		mv.addObject("dto", bankMembersDTO);
		
		mv.setViewName("member/myPage");
		return mv;
	}

}
