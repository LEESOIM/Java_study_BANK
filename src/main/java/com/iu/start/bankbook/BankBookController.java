package com.iu.start.bankbook;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {

	@RequestMapping(value="list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception { 				//1)String
		System.out.println("LIST 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar); //jsp로 보낼 데이터를 model에 담는다
		return "bankbook/list"; //servlet-context.xml에 앞뒤 url포함
	}
	
	
	@RequestMapping(value="detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception { 	//3) ModelAndView
		ModelAndView mv = new ModelAndView(); //매개변수로 선언하거나 메서드내에서 직접 생성해도된다
		System.out.println("DETAIL 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail"); //return대신 경로 지정
		mv.addObject("dto", bankBookDTO);
		return mv;
	}
	
	
	// /bankbook/add GET	/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() throws Exception { 							//2)void
		System.out.println("ADD GET");
//		return "bankbook/add";
		//요청한uri 주소와 jsp경로명이 같으면 리턴을 안하고 void로 할 수 있다
	}
	
	
	
	// /bankbook/add POST	/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		System.out.println("ADD POST");
		System.out.println(bankBookDTO.getBookNum());
		System.out.println(bankBookDTO.getBookSale());
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		Calendar ca = Calendar.getInstance();
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bankBookDAO.setBankBook(bankBookDTO);
		
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}

	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("update POST");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setUpdate(bankBookDTO);
		return "redirect:detail.iu?bookNum="+bankBookDTO.getBookNum();
	}
	
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setDelete(bankBookDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
}
