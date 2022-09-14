package com.iu.start.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {
	
	@GetMapping("error400") //클라이언트 오류
	public ModelAndView error400() throws Exception { 
		ModelAndView mv = new ModelAndView();
		System.out.println("파라미터 틀림"); 
		mv.setViewName("errors/error_404");
		return mv;
	}
	
	@GetMapping("error500") //서버측 오류
	public ModelAndView error500() throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Server Exception 발생(백앤드 에러)"); 
		mv.setViewName("errors/error_404");
		return mv;
	}
}
