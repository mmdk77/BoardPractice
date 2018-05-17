package com.spring.board.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.domain.BoardVO;
import com.spring.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;


	//글 상세 목록
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public BoardVO getBoard(int board_seq) {
		return boardService.getBoard(board_seq);
		
	}
	
	//글 목록
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public List getBoardList() {
		
		List list=boardService.getBoardList();
		
		return list;
		
	}
	
	//글 쓰기
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public void insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
	}
	
	//글 수정
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public void updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
	}
	
	//글 삭제
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public void deleteBoard(int board_seq) {
		boardService.deleteBoard(board_seq);
	}
	
}
