package com.iu.start.bankmembers;

import java.util.List;

public interface MembersDAO {
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	//검색어를 입력해서 ID 찾기
	public List<BankMembersDTO> getSearchByID(String search) throws Exception; 
	
}
