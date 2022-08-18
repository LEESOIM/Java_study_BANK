package com.iu.start.bankbook;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception { 				//1)String
		System.out.println("리스트 실행");
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar); //jsp로 보낼 데이터를 model에 담는다
		return "bankbook/list"; //servlet-context.xml에 앞뒤 경로 추가해줌
	}
	
	
	@RequestMapping(value="detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception { 	//3) ModelAndView
		System.out.println("상세페이지 실행");
		ModelAndView mv = new ModelAndView(); //매개변수로 선언하거나 메서드내에서 직접 생성해도된다
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/detail"); //return대신 경로 지정
		return mv;
	}
	
	
	// /bankbook/add GET	/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() throws Exception { 							//2)void
		System.out.println("상품추가");
	}
	
	// /bankbook/add POST
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("상품추가 완료");
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bankBookService.setBankBook(bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("수정 실행");
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}

	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("수정 완료");
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:detail.iu?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setDelete(bankBookDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
}
