package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	//글목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception {
		ModelAndView mv = new ModelAndView(); //jsp로 보내는 방법 1)Model 2)ModelAndView
		List<BoardDTO> ar = noticeService.getList();
		mv.addObject("list", ar); //데이터를 list라는 이름으로 저장한다
		mv.setViewName("notice/list"); //데이터를 이동할 경로
		return mv;
	}
	
	//글상세보기
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO); //Model은 데이터만 저장(이동X)
		return "notice/detail";
	}
	
	//글쓰기 입력폼
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setAdd() throws Exception {
		//add.iu.jsp는 없는데 되네..?
	}
	
	//글쓰기 Insert
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
		//ModelAndView보단 String으로 redirect해주는게 낫다
	}
	
	//글수정 수정폼
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("notice/update");
		return mv;
	}
	
	//글수정 Update
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setUpdate(boardDTO);
		return "redirect:detail.iu?num="+boardDTO.getNum();
	}
	
	//글삭제
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		return "redirect:list.iu";
	}
	
}
