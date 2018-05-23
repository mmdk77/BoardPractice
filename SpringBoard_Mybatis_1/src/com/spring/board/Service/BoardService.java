package com.spring.board.Service;

import java.util.List;

import com.spring.board.domain.Board;

public interface BoardService {
	
	public Board getBoard(int board_seq);
	public List<Board> getBoardList();
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int board_seq);

}
