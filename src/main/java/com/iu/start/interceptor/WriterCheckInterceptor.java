package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			return;
		}
		
		//로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		//로그인 사용자 정보
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("success");

		//DTO
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) { //일치하지않으면
			modelAndView.setViewName("common/result");
			modelAndView.addObject("result", 1);
			modelAndView.addObject("message", "작성자만 수정이 가능합니다");
			modelAndView.addObject("url", "./list.iu");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
