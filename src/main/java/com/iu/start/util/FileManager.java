package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component //1)Annotation : 객체를 만들어달라
public class FileManager {

	@Autowired //만들어진 객체를 주입시켜 달라
	private ServletContext servletContext;
	
	//save				//2)매개변수 선언
	public void saveFile(ServletContext servletContext, String path, MultipartFile multipartFile) throws Exception {
		//1.실제 경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		//2.폴더(directory) 체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//4.HDD에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);
	}
}
