package com.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.domain.BoardVO;
import com.spring.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//글 목록
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView getBoardList(HttpServletRequest request) {
		
		List list=boardService.getBoardList();
		request.setAttribute("list", list);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("board/list");
		
		return mav;
		
	}
	
	//글 상세 목록
		@RequestMapping(value="/board/{id}", method=RequestMethod.GET)
		public ModelAndView getBoard(int board_seq) {
			
			BoardVO board=boardService.getBoard(board_seq);
			ModelAndView mav=new ModelAndView();
			mav.addObject("board", board);
			return mav;
			
		}
	
	//글 쓰기
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		
		boardService.insertBoard(vo);
		return "redirect:/board";
	}
	
	//글 수정
	@RequestMapping(value="/board/{id}", method=RequestMethod.POST)
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "redirect:/board";
	}
	
	//글 삭제
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public String deleteBoard(int board_seq) {
		boardService.deleteBoard(board_seq);
		return "redirect:/board";
	}
	
}
