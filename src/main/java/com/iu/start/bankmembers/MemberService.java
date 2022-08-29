package com.iu.start.bankmembers;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;

@Service
public class MemberService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
//	@Autowired 주입하지말고 Controller에서 매개변수로 받아서 사용
//	private ServletContext servletContext; //외부와 연결
//	@Autowired
//	private BankAccountDAO bankAccountDAO;

	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext) throws Exception {
		int result = bankMembersDAO.setJoin(bankMembersDTO); //FK인 userName을 참조해야하기 때문에 미리 회원가입 시켜준다
		//1. HDD에 파일을 저장
		//	파일 저장시 경로는 Tomcat 기준이 아니라 OS(운영체제)의 기준으로 설정
		
		//	1) 파일 저장 위치
		//	/resources/upload/member
		
		//	2) 저장할 폴더의 실제 경로 반환(OS 기준)
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("RealPath : "+realPath);
		
		//	3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		File file = new File(realPath);
		
		//*** File 첨부가 없을 때 구분
		if(!photo.isEmpty()) { //if(photo.getSize() != 0)
		
			if(!file.exists()) { //파일이 존재하지 않는다면 디렉토리를 만들어라
				file.mkdirs(); // s : upload폴더도 같이 만들어준다
			}
			
			//	4) 저장할 파일이 중복되지 않게 파일명 생성
			//	-- 시간, java api 이용
			String fileName = UUID.randomUUID().toString();
			System.out.println("fileName : "+fileName);
			
			Calendar ca = Calendar.getInstance(); //현재시간
			Long time = ca.getTimeInMillis(); //밀리세컨으로 변환
			
			fileName = fileName+"_"+photo.getOriginalFilename();
			System.out.println(fileName);
			
		//	5) HDD에 파일 저장
			//어느 폴더에 어떤 이름으로 저장할지 File 객체 생성
			file = new File(file, fileName); //(경로, 저장할파일명)
			
				//1)MultipartFile 클래스의 transferTo 메서드 사용
				photo.transferTo(file);
			
				//2)FileCopyUtils 클래스의 copy 메서드 사용
				
		//2. 저장된 파일 정보를 DB에 저장
		MembersFileDTO membersFileDTO = new MembersFileDTO();
		membersFileDTO.setFileName(fileName);
		membersFileDTO.setOriName(photo.getOriginalFilename());
		membersFileDTO.setUserName(bankMembersDTO.getUserName());
		bankMembersDAO.setAddFile(membersFileDTO);
		
		}//isEmpty 끝
		
		return result;
		
	}
	
	//검색어를 입력해서 ID찾기
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
	//로그인
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//마이페이지
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception { (2)
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		return map;
//	}
	

}