package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository // -> new BankmembersDAO() 하라는 뜻
public class BankMembersDAO implements MembersDAO {

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL 작성
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";
		
		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ? 세팅
		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
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
		
	}
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql ="SELECT USERNAME, NAME FROM BANKMEMBERS WHERE USERNAME=? AND PASSWORD=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassword());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		}else {
			bankMembersDTO=null;
			//return null;
		}
		
		DBConnector.disConnect(rs, st, con);
		return bankMembersDTO;
	}

}