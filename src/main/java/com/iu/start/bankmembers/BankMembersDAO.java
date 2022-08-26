package com.iu.start.bankmembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankmembers.BankMembersDAO.";

	public int setAddFile(MembersFileDTO membersFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAddFile", membersFileDTO);
	}
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMyPage", bankMembersDTO);
	}

}
