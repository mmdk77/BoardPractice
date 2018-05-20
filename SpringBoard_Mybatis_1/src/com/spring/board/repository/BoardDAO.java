package com.spring.board.repository;

import java.util.List;

import com.spring.board.domain.Board;

public interface BoardDAO {
	
	public Board getBoard(Board board);
	public List<Board> getBoardList();
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int board_seq);

}
