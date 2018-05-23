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
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDAOMybatis.insertBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDAOMybatis.updateBoard(board);
	}

	@Override
	public int deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardDAOMybatis.deleteBoard(board_seq);
	}
	
	

}
