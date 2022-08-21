package com.iu.start.notice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankbook.BankBookDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
		return "notice/list";
	}
	
	@RequestMapping(value="detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		noticeDTO = noticeService.getDetail(noticeDTO);
		mv.addObject("dto", noticeDTO);
		mv.setViewName("notice/detail");
		return mv;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() throws Exception {
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		int result = noticeService.setNotice(noticeDTO);
		mv.setViewName("redirect:./list.iu");
		return mv;
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public void update(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}

	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:detail.iu?num="+noticeDTO.getNum();
	}
	
	@RequestMapping(value="delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(noticeDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
}
