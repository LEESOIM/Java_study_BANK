package com.iu.start.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.bankmembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//1. 로그인 사용자 정보
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("success");
		
		boolean check=false;
		
		for(RoleDTO roleDTO:bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleNum());
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("ADMIN")) {
				check=true;
				break;
			}
		}
		
		//admin이 아닐때
		if(!check) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../../../notice/list.iu");
			RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/common/result.jsp"); //jsp로 보내는 foward방식
			view.forward(request, response);
		}
			
		return check;
	}

}
