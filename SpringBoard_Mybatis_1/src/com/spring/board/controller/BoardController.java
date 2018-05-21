package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.Service.BoardService;
import com.spring.board.domain.Board;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;

	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String getBoardList(Model model) {
		
		System.out.println("@@@@@글 목록 가져오기@@@@@@@@@");
		
		List<Board> boardList= boardService.getBoardList();
		model.addAttribute("list", boardList);		
		
		return "board/list";
	}
}
