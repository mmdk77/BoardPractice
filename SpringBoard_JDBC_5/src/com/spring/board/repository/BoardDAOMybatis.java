package com.spring.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardVO;

@Repository
public class BoardDAOMybatis implements BoardDAO{

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public BoardVO getBoard(int board_seq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("BoardVO.selectOne", board_seq);
	}

	@Override
	public List getBoardList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("BoardVO.selectList");
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("BoardVO.insert", vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("BoardVO.update", vo);
	}

	@Override
	public void deleteBoard(int board_seq) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("BoardVO.delete",board_seq);
	}
	
	

}
