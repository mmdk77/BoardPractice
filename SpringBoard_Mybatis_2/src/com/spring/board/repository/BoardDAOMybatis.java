package com.spring.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.Board;

@Repository
public class BoardDAOMybatis implements BoardDAO{

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public Board getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return template.selectOne("Board.selectOne", board_seq);
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return template.selectList("Board.selectList");
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		template.insert("Board.insert",board);
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		template.update("Board.update", board);
		
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		template.delete("Board.delete",board_seq);
		
	}

	
	
}
