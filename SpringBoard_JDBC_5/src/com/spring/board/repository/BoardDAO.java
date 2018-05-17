package com.spring.board.repository;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardDAO {
	
	public BoardVO getBoard(int board_seq);
	public List getBoardList();
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int board_seq);

}
