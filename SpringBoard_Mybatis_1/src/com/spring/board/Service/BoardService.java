package com.spring.board.Service;

import java.util.List;

import com.spring.board.domain.Board;

public interface BoardService {
	
	public Board getBoard(int board_seq);
	public List<Board> getBoardList();
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(int board_seq);

}
