package com.spring.board.repository;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDAO{

	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	public void insertBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	
}
