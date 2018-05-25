package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.domain.Board;
import com.spring.board.service.BoardServiceImpl;

@Controller
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService;

	@RequestMapping(value = "/board/{board_seq}", method = RequestMethod.GET)
	public ModelAndView getBoard(@PathVariable("board_seq") int board_seq) {

		Board board = boardService.getBoard(board_seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("board/detail");

		return mav;
	}

	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String getBoardList(Model model) {

		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("list", boardList);

		return "board/list";
	}

	@RequestMapping(value = "/board/writeForm", method = RequestMethod.GET)
	public String clickWriteForm() {
		return "board/writeForm";
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String insertBoard(Board board) {

		boardService.insertBoard(board);

		return "redirect:board/list";
	}
	
	@RequestMapping(value="/board/updateForm/{board_seq}", method=RequestMethod.GET)
	public String clickUpdateForm(Model model,@PathVariable("board_seq") int board_seq) {
		
		Board board = boardService.getBoard(board_seq);
		model.addAttribute("board", board);
		
		return "board/updateForm";
	}

	@RequestMapping(value="/board/update",method=RequestMethod.POST)
	public String updateBoard(Board board) {
		
		boardService.updateBoard(board);
		return "redirect:board/list";
	}

	@RequestMapping(value="/board/delete/{board_seq}",method=RequestMethod.POST)
	public String deleteBoard(@PathVariable("board_seq") int board_seq) {
		boardService.deleteBoard(board_seq);
		return "redirect:board/list";
	}

}
