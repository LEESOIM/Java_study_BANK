package com.iu.start.bankbook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankbook.BankBookCommentDAO.";
	
	public int setBankBookComment(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setBankBookComment", bankBookCommentDTO);
	}

}
