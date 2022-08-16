package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankmembers.BankMembersDAO."; 

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	
	
	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE '%'||?||'%' ORDER BY USERNAME ASC" ;
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, search); // "%"+search+"%"
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME")); //USERNAME 컬럼에 있는 데이터를 꺼내서 DTO에 세팅해
			bankMembersDTO.setPassword(rs.getString("PASSWORD"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			
			ar.add(bankMembersDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
		
//		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
		
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
		
	}

}
