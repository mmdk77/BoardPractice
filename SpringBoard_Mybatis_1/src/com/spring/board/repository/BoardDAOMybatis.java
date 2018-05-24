package com.spring.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.Board;

@Repository("boardDAOMybatis")
public class BoardDAOMybatis implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		Board board = sqlSessionTemplate.selectOne("Board.selectOne", board_seq);
		return board;
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		List<Board> boardList = sqlSessionTemplate.selectList("Board.selectList");
		return boardList;
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("Board.insert", board);
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("Board.update", board); 
		
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("Board.delete", board_seq);
		 
	}

	
}
