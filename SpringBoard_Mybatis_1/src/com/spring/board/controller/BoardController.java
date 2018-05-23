package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.Service.BoardService;
import com.spring.board.domain.Board;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;

	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String getBoardList(Model model) {
		
		System.out.println("@@@@@글 목록 가져오기@@@@@@@@@");
		
		List<Board> boardList= boardService.getBoardList();
		model.addAttribute("list", boardList);		
		
		return "board/list";
	}

	@RequestMapping(value="/board/{board_seq}", method=RequestMethod.GET)
	public ModelAndView getBoard(@PathVariable("board_seq") int board_seq) {
		
		System.out.println("@@@@글 상세보기@@@@@@");
		
		Board board = boardService.getBoard(board_seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("board/detail");
		return mav;
	}
	
	/*###########################
	#######글 쓰기 이동 Controller########
	###########################*/
	@RequestMapping(value="/board/writeForm")
	public String clickWriteBoard() {
		System.out.println("###########글쓰기 클릭###########");
		return "/board/writeForm";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard(Board board) {
		System.out.println("@@@@@@@@글쓰기@@@@@@@@@@");
		boardService.insertBoard(board);
		return "redirect:/board/list";
	}
	
	
	/*###########################
	#######글 수정 이동 Controller########
	###########################*/
	@RequestMapping(value="/board/editForm/{board_seq}", method=RequestMethod.GET)
	public ModelAndView clickEditBoard(@PathVariable int board_seq) {
		System.out.println("##########글 수정############");
		Board board = boardService.getBoard(board_seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("/board/editForm/{board_seq}");
		return mav;
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String updateBoard(Board board) {
		System.out.println("@@@@@@@글 수정@@@@@@@@@");
		boardService.updateBoard(board);
		return "redirect:/board/list";
	}
	
	
	
	@RequestMapping(value="/board/{board_seq}", method=RequestMethod.POST)
	public String deleteBoard(@PathVariable("board_seq") int board_seq) {
		
		System.out.println("@@@@@@@글 삭제@@@@@@");
		boardService.deleteBoard(board_seq);
		
		return "redirect:/board/list";
		
	}
}
