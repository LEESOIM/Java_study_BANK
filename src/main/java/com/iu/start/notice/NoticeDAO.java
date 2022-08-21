package com.iu.start.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}	
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}	
	
	public int setNotice(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setNotice", noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
}
