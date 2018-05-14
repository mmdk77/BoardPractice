package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardVO;

public interface BoardService {

	public BoardVO getBoard(int board_seq);
	public List<BoardVO> getBoardList();
	public void insertBoard(BoardVO vo);
	public void deleteBoard(int board_seq);
	public void updateBoard(BoardVO vo);
}
