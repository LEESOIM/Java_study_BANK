package com.iu.start.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookDAO.";
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBankBook", bankBookDTO);
	}

	public List<BankBookDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setChangeSale", bankBookDTO);
	}

	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", bankBookDTO);
	}
}
