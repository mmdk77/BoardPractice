package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {

	//CRUD 기능의 메소드 구현
	//글등록
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	
}
