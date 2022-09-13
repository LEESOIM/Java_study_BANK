package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDAO;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private BankMembersDAO bankMembersDAO; //preHandle에서 DB접근이 필요할때 사용
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("success");
		System.out.println(bankMembersDAO); 
		if(obj!=null) {
			System.out.println("로그인 함");
			return true;
		}else {
			System.out.println("로그인 안함");
			response.sendRedirect("../../../../member/login.iu");
			return false;
		}
	}
}
