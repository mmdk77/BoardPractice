package com.spring.board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardDAOMybatis;

@Service("boardService")
public class boardServiceImpl implements BoardService{

	@Autowired
	@Qualifier("boardDAOMybatis")
	private BoardDAOMybatis boardDAOMybatis;
	
	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAOMybatis.getBoard(board_seq);
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAOMybatis.getBoardList();
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardDAOMybatis.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardDAOMybatis.updateBoard(board);
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardDAOMybatis.deleteBoard(board_seq);
	}
	
	

}
