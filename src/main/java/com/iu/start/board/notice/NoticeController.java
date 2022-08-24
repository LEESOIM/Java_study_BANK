package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView(); //jsp로 보내는 방법 1)Model 2)ModelAndView
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar); //데이터를 "list"라는 이름으로 저장한다
		mv.addObject("pager", pager); //주소값을 "pager"라는 이름으로 저장한다
		mv.setViewName("board/list"); //데이터들을 이동할 경로
		return mv;
	}
	
	//글상세보기
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO); //Model은 데이터만 저장(이동X)
		return "board/detail";
	}
	
	//글쓰기 입력폼
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd() throws Exception {
		return "board/add";
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
		mv.setViewName("board/update");
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
