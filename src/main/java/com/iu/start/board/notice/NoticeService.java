package com.iu.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;
	
	
	@Override
	public int setFileDelete(BoardFileDTO boardFileDTO, ServletContext servletContext) throws Exception {
		boardFileDTO = noticeDAO.getFileDetail(boardFileDTO);
		int result = noticeDAO.setFileDelete(boardFileDTO);
		String path = "resources/upload/notice";
		
		if(result>0) {
			boolean check =	fileManager.deleteFile(servletContext, path, boardFileDTO);
			System.out.println("fileDelete :"+check);
		}
		return result;
	}

	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {

		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);

		pager.getRowNum();

		return noticeDAO.getList(pager);

//		//페이지에 글 10개씩 출력 기준
//		//page			sartRow			lastRow
//		//1				1				10
//		//2				11				20
//		//3				21				30
//		Long perPage=10L; //한 페이지에 출력할 글의 갯수
//		Long startRow = (page-1)*perPage+1;
//		Long lastRow = page*perPage;
//		
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);

//		/**
//		* JSP에 페이지 번호 출력 1 ~ ?
//		* 1. 글의 총갯수
//		* 2. 글의 총갯수를 이용해서 페이지 수 구하기
//		**/	
//		Long totalCount = noticeDAO.getCount();
//		Long totalPage = totalCount/perPage; 
//		if(totalCount%perPage != 0) {
//			totalPage = totalPage+1;
//		}
//		/**
//		* 3. totalBlock 갯수 구하기
//		* Block	   : 
//		* perBlock : 한 페이지 하단에 출력할 번호의 수
//		**/
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}

//		/**
//		* 4. page로 현재 Block 번호 찾기
//		* page		curBlock
//		* 1~5		1
//		* 6~10		2
//		* 11		3
//		**/
//		Long curBlock = page/perBlock;
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		/**
//		* 5. curBlock로 시작번호와 끝번호 알아오기
//		* curBlock	startNum	lastNum
//		* 1			1			5
//		* 2			6			10
//		* 3			11			15
//		**/		
//		Long startNum = (curBlock-1)*perBlock+1; 
//		Long lastNum = curBlock*perBlock;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {

		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";

		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
				continue;
			}

			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			System.out.println(boardDTO.getNum());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}

		return result;
		
		
//		//저장할 폴더의 실제 경로 반환(OS 기준)
//		String realPath = servletContext.getRealPath("resources/upload/notice");
//		System.out.println("RealPath : "+realPath);
//		
//		//저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//		if(!file.exists()) {
//			file.mkdirs();
//		}
//		
//		
//		for(MultipartFile mf:files) {
//			if(mf.isEmpty()) {
//				continue; //비어있으면 다음꺼 실행
//			}
//			
//			//file = new File(realPath);
//			
//			//저장하는 코드
//			String fileName = UUID.randomUUID().toString();
//			fileName = fileName+"_"+mf.getOriginalFilename();
//
//			File dest = new File(file, fileName);//폴더, 파일명
//			mf.transferTo(dest);
//
//			BoardFileDTO boardFileDTO = new BoardFileDTO();
//			boardFileDTO.setFileName(fileName);
//			boardFileDTO.setOriName(mf.getOriginalFilename());
//			boardFileDTO.setNum(boardDTO.getNum());
//			noticeDAO.setAddFile(boardFileDTO);
//			
//		}
		
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		String path = "resources/upload/notice";
		int result = noticeDAO.setUpdate(boardDTO);
		
		if(result<1) {
			return result;
		}
		for (MultipartFile multipartFile : files) {
			if (multipartFile.isEmpty()) {
				continue;
			}

			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			System.out.println(boardDTO.getNum());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}

}
