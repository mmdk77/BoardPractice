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
		return sqlSessionTemplate.selectOne("Board.selectOne", board_seq);
	}

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("Board.selectList");
	}

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("Board.insert", board);
	}

	@Override
	public int updateBoard(Board board) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("Board.update", board);
	}

	@Override
	public int deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("Board.delete", board_seq);
	}

	
}
