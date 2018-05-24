package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardDAOMybatis;

@Service
public class BoardServiceImpl implements boardService{

	@Autowired
	private BoardDAOMybatis boardMybatis;
	
	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return boardMybatis.getBoard(board_seq);
		
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardMybatis.getBoardList();
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		boardMybatis.insertBoard(board);
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		boardMybatis.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		boardMybatis.deleteBoard(board_seq);
	}
	
	
	
	

}
