package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO{

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKBOOK VALUES(?,?,?,1)";
		
		PreparedStatement st = con.prepareStatement(sql);

		Long now = System.currentTimeMillis();
		st.setLong(1, now);
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
	
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			
			ar.add(bankBookDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKSALE=? WHERE BOOKNUM=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, bankBookDTO.getBookSale());
		st.setLong(2, bankBookDTO.getBookNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO dto = null;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setLong(1, bankBookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			dto = new BankBookDTO();
			dto.setBookNum(rs.getLong("BOOKNUM"));
			dto.setBookName(rs.getString("BOOKNAME"));
			dto.setBookRate(rs.getDouble("BOOKRATE"));
			dto.setBookSale(rs.getInt("BOOKSALE"));
		}
		DBConnector.disConnect(rs, st, con);
		return dto;
	}


	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKNAME=?, BOOKRATE=? WHERE BOOKNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "DELETE BANKBOOK WHERE BOOKNUM=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bankBookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
